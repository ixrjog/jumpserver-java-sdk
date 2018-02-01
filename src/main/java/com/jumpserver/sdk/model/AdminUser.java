package com.jumpserver.sdk.model;

import java.util.Date;

public class AdminUser {
    private String id;

    private String name;

    private String username;

    private String password;

    private Date dateCreated;

    private Date dateUpdated;

    private String createdBy;

    private Boolean become;

    private String becomeMethod;

    private String becomeUser;

    private String becomePass;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public Boolean getBecome() {
        return become;
    }

    public void setBecome(Boolean become) {
        this.become = become;
    }

    public String getBecomeMethod() {
        return becomeMethod;
    }

    public void setBecomeMethod(String becomeMethod) {
        this.becomeMethod = becomeMethod == null ? null : becomeMethod.trim();
    }

    public String getBecomeUser() {
        return becomeUser;
    }

    public void setBecomeUser(String becomeUser) {
        this.becomeUser = becomeUser == null ? null : becomeUser.trim();
    }

    public String getBecomePass() {
        return becomePass;
    }

    public void setBecomePass(String becomePass) {
        this.becomePass = becomePass == null ? null : becomePass.trim();
    }
}