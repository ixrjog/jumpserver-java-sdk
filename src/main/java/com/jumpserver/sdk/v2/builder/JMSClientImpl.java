package com.jumpserver.sdk.v2.builder;

import com.jumpserver.sdk.v2.api.Apis;
import com.jumpserver.sdk.v2.httpclient.Config;
import com.jumpserver.sdk.v2.jumpserver.assets.AssertsService;
import com.jumpserver.sdk.v2.jumpserver.luna.LunaService;
import com.jumpserver.sdk.v2.jumpserver.permissions.PermissionService;
import com.jumpserver.sdk.v2.jumpserver.users.UserService;

import java.util.Map;

/**
 * @author yankaijun
 * @date 2018/10/16 上午9:16
 */
public class JMSClientImpl implements JMSClient {

    private Token token;
    private Map<String, Object> headers;

    @SuppressWarnings("rawtypes")
    private static final ThreadLocal<JMSClientImpl> sessions = new ThreadLocal<JMSClientImpl>();

    public static JMSClientImpl getCurrent() {
        return sessions.get();
    }

    @Override
    public UserService users() {
        return Apis.getUserServices();
    }

    @Override
    public AssertsService assets() {
        return Apis.getAssetsServices();
    }

    @Override
    public LunaService luna() {
        return Apis.getLunaServices();
    }

    @Override
    public PermissionService permissions() {
        return Apis.getPermissionServices();
    }

    public static JMSClient createSession(Token token, Map<String, Object> headers) {
        return new JMSClientImpl(token, headers);
    }

    private JMSClientImpl(Token token, Map<String, Object> headers) {
        this.headers = headers;
        this.token = token;
        sessions.set(this);
    }

    public Token getToken() {
        return token;
    }

    public Config getConfig() {
        return Config.newConfig();
    }

    public Map getHeaders() {
        return this.headers;
    }

}


