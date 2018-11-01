package com.jumpserver.sdk.v2.model;

/**
 * @author yankaijun
 * @date 2018/10/31 11:34 AM
 */
public class OrgUsers {

    private String orgId;
    private String[] users;
    private String[] admins;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String[] getUsers() {
        return users;
    }

    public void setUsers(String[] users) {
        this.users = users;
    }

    public String[] getAdmins() {
        return admins;
    }

    public void setAdmins(String[] admins) {
        this.admins = admins;
    }
}
