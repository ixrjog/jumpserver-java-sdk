package com.jumpserver.sdk.model;

import java.util.Date;

public class Assetpermission {
    private String id;

    private String name;

    private Boolean is_active;

    private Date date_expired;

    private String created_by;

    private Date date_created;

    private String comment;

    private String[] user_groups;

    private String[] users;

    private String[] asset_groups;

    private String[] assets;

    private String[] system_users;

    public String[] getUser_groups() {
        return user_groups;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }

    public Date getDate_expired() {
        return date_expired;
    }

    public void setDate_expired(Date date_expired) {
        this.date_expired = date_expired;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setUser_groups(String[] user_groups) {
        this.user_groups = user_groups;
    }

    public String[] getUsers() {
        return users;
    }

    public void setUsers(String[] users) {
        this.users = users;
    }

    public String[] getAsset_groups() {
        return asset_groups;
    }

    public void setAsset_groups(String[] asset_groups) {
        this.asset_groups = asset_groups;
    }

    public String[] getAssets() {
        return assets;
    }

    public void setAssets(String[] assets) {
        this.assets = assets;
    }

    public String[] getSystem_users() {
        return system_users;
    }

    public void setSystem_users(String[] system_users) {
        this.system_users = system_users;
    }
}