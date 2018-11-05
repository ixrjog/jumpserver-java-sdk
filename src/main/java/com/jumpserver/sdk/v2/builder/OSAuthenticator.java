package com.jumpserver.sdk.v2.builder;

import com.alibaba.fastjson.JSONObject;
import com.jumpserver.sdk.v2.common.ClientConstants;
import com.jumpserver.sdk.v2.common.HttpMethod;
import com.jumpserver.sdk.v2.exceptions.AuthenticationException;
import com.jumpserver.sdk.v2.httpclient.HttpEntityHandler;
import com.jumpserver.sdk.v2.httpclient.HttpExecutor;
import com.jumpserver.sdk.v2.httpclient.HttpRequest;
import com.jumpserver.sdk.v2.httpclient.HttpResponse;
import com.jumpserver.sdk.v2.model.Org;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class OSAuthenticator {

    private static final String TOKEN_INDICATOR = "Tokens";
    private static final Logger LOG = LoggerFactory.getLogger(OSAuthenticator.class);
    private static Map<String, Object> headers;

    @SuppressWarnings("rawtypes")
    public static JMSClient invoke(String endpoint, String name, String password, Map<String, Object> headersToSession) {
        headers = headersToSession;
        return authenticate(endpoint, name, password);
    }

    private static JMSClient authenticate(String endpoint, String username, String password) throws AuthenticationException {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", username);
        jsonObject.put("password", password);

        if (endpoint.endsWith("/")) {
            endpoint = endpoint.substring(0, endpoint.length() - 1);
        }

        //获得token的请求
        HttpRequest<Token> request = HttpRequest.builder(Token.class)
                .endpoint(endpoint)
                .method(HttpMethod.POST)
                .header(ClientConstants.HEADER_FOR_AUTH, TOKEN_INDICATOR)
                .json(jsonObject.toString())
                .path(ClientConstants.TOKEN)
                .build();

        JMSClient client;
        Token token;
        try {
            HttpResponse response = HttpExecutor.create().execute(request);

            if (response.getStatus() >= 400) {
                try {
                    throw new AuthenticationException(response.getStatusMessage());
                } finally {
                    HttpEntityHandler.closeQuietly(response);
                }
            }
            token = response.getEntity(Token.class);
            token.setUsername(username);
            token.setPassword(password);
            token.setEndpoint(endpoint);
            token.setXpack(false);
            client = JMSClientImpl.createSession(token, headers);
        } catch (Exception e) {
            throw new AuthenticationException(e.getMessage());
        }
        //TODO 优化这个逻辑
        if (headers.get(ClientConstants.X_JMS_ORG) == null) {
            try {
                //这个api存在就有xpack插件
                List<Org> orgs = client.orgs().listOrg();
                if (orgs.size() <= 0) {
                    token.setXpack(true);
                    client = JMSClientImpl.createSession(token, headers);
                }
            } catch (Exception e) {
                LOG.error("访问xpack插件失败，不存在xpack插件");
                e.printStackTrace();
            }
        }
        return client;
    }

    public static void reAuthenticate() {
        LOG.debug("Re-Authenticating session due to expired Token or invalid response");
        JMSClient session = JMSClientImpl.getCurrent();
        Token token = session.getToken();
        authenticate(token.getEndpoint(), token.getUsername(), token.getPassword());
    }

}
