package com.jumpserver.sdk.model;

import java.util.Date;

public class Usergroup {
    private String id;

    private Boolean isDiscard;

    private Date discardTime;

    private String name;

    private Date dateCreated;

    private String createdBy;

    private String comment;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Boolean getIsDiscard() {
        return isDiscard;
    }

    public void setIsDiscard(Boolean isDiscard) {
        this.isDiscard = isDiscard;
    }

    public Date getDiscardTime() {
        return discardTime;
    }

    public void setDiscardTime(Date discardTime) {
        this.discardTime = discardTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }
}