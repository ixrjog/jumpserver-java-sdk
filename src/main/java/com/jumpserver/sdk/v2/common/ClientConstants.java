package com.jumpserver.sdk.v2.common;

public final class ClientConstants {

    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String BEARER = "Bearer ";
    public static final String X_JMS_ORG = "X-JMS-ORG";

    public static final String HEADER_CONTENT_TYPE = "Content-Type";
    public static final String HEADER_FOR_AUTH = "Auth-request";
    public static final String CONTENT_TYPE_JSON = "application/json";

    public static final String HEADER_X_SUBJECT_TOKEN = "X-Subject-Token";
    public static final String HEADER_ACCEPT = "Accept";
    public static final String HEADER_USER_AGENT = "User-Agent";
    public static final String CONTENT_TYPE_OCTECT_STREAM = "application/octet-stream";
    public static final String CONTENT_TYPE_TEXT = "text/plain";
    public static final String CONTENT_TYPE_TEXT_HTML = "text/html";

    // Paths
    public static final String TOKEN = "/api/users/v1/auth/";
    public static final String URI_SEP = "/";

    // user
    public static final String USERS = "/api/users/v1/users/";
    public static final String USERGROUPS = "/api/users/v1/groups/";
    public static final String USER_PASSWORD_RESET = "/api/users/v1/users/{id}/password/";

    // assets
    public static final String NODES = "/api/assets/v1/nodes/";

    // nodes
    public static final String ASSETS = "/api/assets/v1/assets/";

    //org
    public static final String ORG = "/xpack/orgs/api/v1/orgs/";

    // nodes children
    public static final String NODES_CHILDREN = "/api/assets/v1/nodes/{id}/children/";
    public static final String NODES_CHILDREN_ADD = "/api/assets/v1/nodes/{id}/children/add/";
    public static final String NODES_ASSETS_ADD = "/api/assets/v1/nodes/{id}/assets/add/";
    public static final String NODES_ASSETS_REMOVE = "/api/assets/v1/nodes/{id}/assets/remove/";

    // label
    public static final String LABELS = "/api/assets/v1/labels/";

    // admin_user
    public static final String ADMIN_USERS = "/api/assets/v1/admin-user/";
    public static final String ADMIN_USERS_CLUSTER = "/api/assets/v1/admin-user/{id}/clusters/";
    public static final String ADMIN_USERS_AUTH = "/api/assets/v1/admin-user/{id}/auth/";

    // system_user
    public static final String SYSTEM_USERS = "/api/assets/v1/system-user/";
    public static final String SYSTEM_USERS_AUTHINFO = "/api/assets/v1/system-user/{id}/auth-info/";
    public static final String SYSTEM_USERS_PUSH = "/api/assets/v1/system-user/{id}/push/";

    // permission
    public static final String ASSET_PERMISSIONS = "/api/perms/v1/asset-permissions/";

    // luna
    public static final String LUNA_TOKEN = "/api/users/v1/connection-token/";
    public static final String LUNA_TOKEN_VALIDATE = "/api/users/v1/connection-token/?token=";
    public static final String LUNA_LINUX_CONNECT = "/luna/connect?system=linux&token=";
    public static final String LUNA_WINDOWS_CONNECT = "/luna/connect?system=windows&token=";

}
