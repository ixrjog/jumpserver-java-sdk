package com.jumpserver.sdk.model;

import java.util.Date;

public class Assetpermission {
    private String id;

    private String name;

    private Boolean isActive;

    private Date dateExpired;

    private String createdBy;

    private Date dateCreated;

    private String comment;

    private String[] user_groups;

    private String[] asset_groups;

    private String[] system_users;

    public String[] getUser_groups() {
        return user_groups;
    }

    public void setUser_groups(String[] user_groups) {
        this.user_groups = user_groups;
    }

    public String[] getAsset_groups() {
        return asset_groups;
    }

    public void setAsset_groups(String[] asset_groups) {
        this.asset_groups = asset_groups;
    }

    public String[] getSystem_users() {
        return system_users;
    }

    public void setSystem_users(String[] system_users) {
        this.system_users = system_users;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Date getDateExpired() {
        return dateExpired;
    }

    public void setDateExpired(Date dateExpired) {
        this.dateExpired = dateExpired;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }
}