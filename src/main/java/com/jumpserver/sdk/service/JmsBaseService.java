package com.jumpserver.sdk.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jumpserver.sdk.base.ApiConstants;
import com.jumpserver.sdk.base.ApiType;
import com.jumpserver.sdk.base.JmsException;
import com.jumpserver.sdk.request.JmsRequest;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class JmsBaseService {

    public String URL;
    public String USERNAME;
    public String PASSWORD;
    public String TOKEN;

    public JmsBaseService(String url, String username, String password) {
        this.URL = url;
        this.USERNAME = username;
        this.PASSWORD = password;
        getToken();
    }

    public String getToken() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", USERNAME);
        jsonObject.put("password", PASSWORD);
        try {
            Map<String, String> map = JmsRequest.getRequest(URL + ApiConstants.TOKEN, jsonObject.toString(), ApiType.API_POST, null);
            String token = "Bearer " + JSON.parseObject(map.get("resultStr")).getString("token");
            this.TOKEN = token;
            return token;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Map<String, String> add(Object object, String apiUrl) {
        try {
            String jsonStr = JSON.toJSONString(object);
            Map<String, String> map = JmsRequest.getRequest(this.URL + apiUrl, jsonStr, ApiType.API_POST, this.TOKEN);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            throw new JmsException(e.getMessage());
        }
    }

    public Map<String, String> updateX(Object object, String apiUrl, String id) {
        try {
            String jsonStr = JSON.toJSONString(object);
            JSONObject jsonObject = JSON.parseObject(jsonStr);
            jsonObject.remove("id");
            jsonStr = jsonObject.toString();
            apiUrl = apiUrl.replaceAll("\\{" + "id" + "\\}", id);
            Map<String, String> map = JmsRequest.getRequest(this.URL + apiUrl, jsonStr, ApiType.API_PATCH, this.TOKEN);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            throw new JmsException(e.getMessage());
        }
    }

    public Map<String, String> update(Object object, String apiUrl, String id) {
        try {
            if (StringUtils.isBlank(id)) {
                throw new JmsException("请填写ID信息");
            }
            String jsonStr = JSON.toJSONString(object);
            Map<String, String> map = JmsRequest.getRequest(this.URL + apiUrl + id + "/", jsonStr, ApiType.API_PATCH, this.TOKEN);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            throw new JmsException(e.getMessage());
        }
    }

    public Map<String, String> delete(Object object, String apiUrl, String id) {
        try {
            if (StringUtils.isBlank(id)) {
                throw new JmsException("请填写ID信息");
            }
            String jsonStr = JSON.toJSONString(object);
            Map<String, String> map = JmsRequest.getRequest(this.URL + apiUrl + id + "/", jsonStr, ApiType.API_DELETE, this.TOKEN);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            throw new JmsException(e.getMessage());
        }
    }

    public Map<String, String> query(String id, String apiUrl) {
        try {
            Map<String, String> map = new HashMap<>();
            if (StringUtils.isNotBlank(id)) {
                apiUrl = apiUrl.replaceAll("\\{" + "id" + "\\}", id);
            }
            map = JmsRequest.getRequest(this.URL + apiUrl, null, ApiType.API_GET, this.TOKEN);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            throw new JmsException(e.getMessage());
        }
    }

}
