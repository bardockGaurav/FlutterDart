package com.dartCrud.myDartCrud.crudApp.common;

public class AbstractEntityInfo {
    private Long dateCreated;
    private Long lastModified;
    private String createdBy;
    private String lastModifiedBy;
    private Boolean isDeleted;

    public AbstractEntityInfo() {
        this.isDeleted = Boolean.FALSE;
    }

    public AbstractEntityInfo(Long dateCreated, Long lastModified, String createdBy, String lastModifiedBy,
        Boolean isDeleted) {
        this.dateCreated = dateCreated;
        this.lastModified = lastModified;
        this.createdBy = createdBy;
        this.lastModifiedBy = lastModifiedBy;
        this.isDeleted = isDeleted;
    }

    public Long getDateCreated() {
        return this.dateCreated;
    }

    public void setDateCreated(Long dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Long getLastModified() {
        return this.lastModified;
    }

    public void setLastModified(Long lastModified) {
        this.lastModified = lastModified;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getLastModifiedBy() {
        return this.lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}
