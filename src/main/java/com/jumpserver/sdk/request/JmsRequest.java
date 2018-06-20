package com.jumpserver.sdk.request;

import com.jumpserver.sdk.base.ApiType;
import com.jumpserver.sdk.base.JmsException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.*;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

public class JmsRequest {

    public static Map<String, String> getRequest(String url, String json, ApiType type, String token) throws Exception {
        Map<String, String> map = new HashMap<>();
        EntityBuilder entityBuilder = EntityBuilder.create();
        entityBuilder.setText(json);
        entityBuilder.setContentType(ContentType.APPLICATION_JSON);
        entityBuilder.setContentEncoding("UTF-8");
        HttpEntity requestEntity = entityBuilder.build();
        switch (type) {
            case API_POST:
                HttpPost httpPost = new HttpPost(url);
                httpPost.setEntity(requestEntity);
                map = apiRequest(httpPost,token);
                break;
            case API_GET:
                HttpGet httpGet = new HttpGet(url);
                map = apiRequest(httpGet,token);
                break;
            case API_DELETE:
                HttpDelete httpDelete = new HttpDelete(url);
                map = apiRequest(httpDelete,token);
                break;
            //全部更新
            case API_PUT:
                HttpPut httpPut = new HttpPut(url);
                httpPut.setEntity(requestEntity);
                map = apiRequest(httpPut,token);
                break;
            //局部更新
            case API_PATCH:
                HttpPatch httpPatch = new HttpPatch(url);
                httpPatch.setEntity(requestEntity);
                map = apiRequest(httpPatch,token);
                break;
            case API_TOKEN:
                HttpPost httpToeknPost = new HttpPost(url);
                httpToeknPost.setEntity(requestEntity);
                map = tokenRequest(httpToeknPost);
                break;
            default:
                break;
        }
        return map;
    }

    private static Map<String, String> apiRequest(HttpRequestBase request,String token) throws Exception {
        request.addHeader("Content-Type", "application/json");
        request.addHeader("Authorization", token);
        request.addHeader("Content-Encoding", "UTF-8");
        CloseableHttpClient httpclient = HttpClients.createDefault();
        RequestConfig config = RequestConfig.custom().setSocketTimeout(10000).setConnectionRequestTimeout(10000).build();
        request.setConfig(config);
        HttpResponse response = httpclient.execute(request);
        return checkoutApiResult(httpclient,response);
    }

    private static  Map<String, String>  tokenRequest(HttpRequestBase request) throws Exception {
        request.addHeader("Content-Type", "application/json");
        request.addHeader("Content-Encoding", "UTF-8");
        CloseableHttpClient httpclient = HttpClients.createDefault();
        RequestConfig config = RequestConfig.custom().setSocketTimeout(10000).setConnectionRequestTimeout(10000).build();
        request.setConfig(config);
        HttpResponse response = httpclient.execute(request);
        Map<String, String> map = checkoutApiResult(httpclient, response);
        return  map;
    }


    private static Map<String, String>  checkoutApiResult(CloseableHttpClient httpclient, HttpResponse response) throws Exception {
        Map<String, String> map = new HashMap<>();
        int code = response.getStatusLine().getStatusCode();
        map.put("code", String.valueOf(code));
        String strResult = "";
        if (code >= 400) {
            if (null != response.getEntity()) {
                strResult += EntityUtils.toString(response.getEntity(), "UTF-8");
            }
            throw new JmsException(strResult);
        } else {
            //删除成功也不返回数据
            if (null != response.getEntity()) {
                strResult += EntityUtils.toString(response.getEntity(), "UTF-8");
            }
        }
        map.put("resultStr", strResult);
        if (httpclient != null) {
            httpclient.close();
        }
        return map;
    }

}
