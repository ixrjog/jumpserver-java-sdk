package com.jumpserver.sdk.model;

import java.util.Date;

public class AdminUser {
    private String id;

    private String name;

    private String username;

    private String _password;

    private Date date_created;

    private Date date_updated;

    private String created_by;

    private String _private_key;

    private String _public_key;

    private Boolean become;

    private String become_method;

    private String become_user;

    private String _become_pass;

    private String comment;

    private String[] clusters;

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

    public String get_password() {
        return _password;
    }

    public void set_password(String _password) {
        this._password = _password;
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

    public String get_private_key() {
        return _private_key;
    }

    public void set_private_key(String _private_key) {
        this._private_key = _private_key;
    }

    public String get_public_key() {
        return _public_key;
    }

    public void set_public_key(String _public_key) {
        this._public_key = _public_key;
    }

    public Boolean getBecome() {
        return become;
    }

    public void setBecome(Boolean become) {
        this.become = become;
    }

    public String getBecome_method() {
        return become_method;
    }

    public void setBecome_method(String become_method) {
        this.become_method = become_method;
    }

    public String getBecome_user() {
        return become_user;
    }

    public void setBecome_user(String become_user) {
        this.become_user = become_user;
    }

    public String get_become_pass() {
        return _become_pass;
    }

    public void set_become_pass(String _become_pass) {
        this._become_pass = _become_pass;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String[] getClusters() {
        return clusters;
    }

    public void setClusters(String[] clusters) {
        this.clusters = clusters;
    }
}