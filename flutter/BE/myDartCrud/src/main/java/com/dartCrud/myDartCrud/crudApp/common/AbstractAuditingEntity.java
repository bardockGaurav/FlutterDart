package com.dartCrud.myDartCrud.crudApp.common;

import jakarta.persistence.*;

@MappedSuperclass
public class AbstractAuditingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "lastModifiedBy")
    private String lastModifiedBy;

    @Column(name = "LastModified",nullable = false)
    private long lastModified;

    @Column(name = "createdBy",nullable = false)
    private String createdBy;

    @Column(name = "dateCreated",nullable = false)
    private long dateCreated;

    @Column(name = "isDeleted", nullable = false)
    private Boolean isDeleted;

    public AbstractAuditingEntity() {
        this.isDeleted = Boolean.FALSE;
    }

    public AbstractAuditingEntity(AbstractAuditingEntity other) {
        this.isDeleted = Boolean.FALSE;
        this.id = other.id;
        this.dateCreated = other.dateCreated;
        this.lastModified = other.lastModified;
        this.createdBy = other.createdBy;
        this.lastModifiedBy = other.lastModifiedBy;
        this.isDeleted = other.isDeleted;
    }

    public AbstractAuditingEntity(String lastModifiedBy, long lastModified, String createdBy, long dateCreated,
        boolean isDeleted) {
        this.lastModifiedBy = lastModifiedBy;
        this.lastModified = lastModified;
        this.createdBy = createdBy;
        this.dateCreated = dateCreated;
        this.isDeleted = isDeleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public long getLastModified() {
        return lastModified;
    }

    public void setLastModified(long lastModified) {
        this.lastModified = lastModified;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public long getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(long dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}
