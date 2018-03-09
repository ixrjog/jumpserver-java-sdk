package com.jumpserver.sdk.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class SystemUser {
    private String id;

    private String name;

    private String username;

    private String _password;

    private String _private_key;

    private String _public_key;

    private String comment;

    private Date date_created;

    private Date date_updated;

    private String created_by;

    private Integer priority;

    private String protocol;

    private Boolean auto_push;

    private String sudo;

    private String shell;

    private String[] nodes;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JSONField(name = "_password")
    public String get_password() {
        return _password;
    }

    @JSONField(name = "_password")
    public void set_password(String _password) {
        this._password = _password;
    }

    @JSONField(name = "_private_key")
    public String get_private_key() {
        return _private_key;
    }

    @JSONField(name = "_private_key")
    public void set_private_key(String _private_key) {
        this._private_key = _private_key;
    }

    @JSONField(name = "_public_key")
    public String get_public_key() {
        return _public_key;
    }

    @JSONField(name = "_public_key")
    public void set_public_key(String _public_key) {
        this._public_key = _public_key;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public Date getDate_updated() {
        return date_updated;
    }

    public void setDate_updated(Date date_updated) {
        this.date_updated = date_updated;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
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
        this.protocol = protocol;
    }

    public Boolean getAuto_push() {
        return auto_push;
    }

    public void setAuto_push(Boolean auto_push) {
        this.auto_push = auto_push;
    }

    public String getSudo() {
        return sudo;
    }

    public void setSudo(String sudo) {
        this.sudo = sudo;
    }

    public String getShell() {
        return shell;
    }

    public void setShell(String shell) {
        this.shell = shell;
    }

    public String[] getNodes() {
        return nodes;
    }

    public void setNodes(String[] nodes) {
        this.nodes = nodes;
    }
}