package com.jumpserver.sdk.model;

import java.util.Date;

public class SystemUser {
    private String id;

    private String name;

    private String username;

    private String password;

    private Date dateCreated;

    private Date dateUpdated;

    private String createdBy;

    private Integer priority;

    private String protocol;

    private Boolean autoPush;

    private String shell;

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

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol == null ? null : protocol.trim();
    }

    public Boolean getAutoPush() {
        return autoPush;
    }

    public void setAutoPush(Boolean autoPush) {
        this.autoPush = autoPush;
    }

    public String getShell() {
        return shell;
    }

    public void setShell(String shell) {
        this.shell = shell == null ? null : shell.trim();
    }
}