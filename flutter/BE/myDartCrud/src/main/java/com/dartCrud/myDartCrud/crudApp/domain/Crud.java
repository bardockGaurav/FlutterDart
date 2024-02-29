package com.dartCrud.myDartCrud.crudApp.domain;


import com.dartCrud.myDartCrud.crudApp.common.AbstractAuditingEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="crud")
public class Crud extends AbstractAuditingEntity {

    @Column(name="crudId")
    private long crudId;
    @Column(name="userName")
    private String userName;
    @Column(name="age")
    private Integer age;
    @Column(name="phoneNumber")
    private Integer phoneNumber;
    @Column(name="address")
    private String address;
    public Crud(){}

    public Crud(String lastModifiedBy, long lastModified, String createdBy, long dateCreated, boolean isDeleted, long crudId, String userName, Integer age, Integer phoneNumber, String address) {
        super(lastModifiedBy, lastModified, createdBy, dateCreated, isDeleted);
        this.crudId = crudId;
        this.userName = userName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public long getCrudId() {
        return crudId;
    }

    public void setCrudId(long crudId) {
        this.crudId = crudId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static interface LastModifiedByStep {
        LastModifiedStep withLastModifiedBy(String lastModifiedBy);
    }

    public static interface LastModifiedStep {
        CreatedByStep withLastModified(long lastModified);
    }

    public static interface CreatedByStep {
        DateCreatedStep withCreatedBy(String createdBy);
    }

    public static interface DateCreatedStep {
        IsDeletedStep withDateCreated(long dateCreated);
    }

    public static interface IsDeletedStep {
        CrudIdStep withIsDeleted(boolean isDeleted);
    }

    public static interface CrudIdStep {
        UserNameStep withCrudId(long crudId);
    }

    public static interface UserNameStep {
        AgeStep withUserName(String userName);
    }

    public static interface AgeStep {
        PhoneNumberStep withAge(Integer age);
    }

    public static interface PhoneNumberStep {
        AddressStep withPhoneNumber(Integer phoneNumber);
    }

    public static interface AddressStep {
        BuildStep withAddress(String address);
    }

    public static interface BuildStep {
        Crud build();
    }

    public static class Builder implements LastModifiedByStep, LastModifiedStep, CreatedByStep, DateCreatedStep, IsDeletedStep, CrudIdStep, UserNameStep, AgeStep, PhoneNumberStep, AddressStep, BuildStep {
        private String lastModifiedBy;
        private long lastModified;
        private String createdBy;
        private long dateCreated;
        private boolean isDeleted;
        private long crudId;
        private String userName;
        private Integer age;
        private Integer phoneNumber;
        private String address;

        private Builder() {
        }

        public static LastModifiedByStep crud() {
            return new Builder();
        }

        @Override
        public LastModifiedStep withLastModifiedBy(String lastModifiedBy) {
            this.lastModifiedBy = lastModifiedBy;
            return this;
        }

        @Override
        public CreatedByStep withLastModified(long lastModified) {
            this.lastModified = lastModified;
            return this;
        }

        @Override
        public DateCreatedStep withCreatedBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        @Override
        public IsDeletedStep withDateCreated(long dateCreated) {
            this.dateCreated = dateCreated;
            return this;
        }

        @Override
        public CrudIdStep withIsDeleted(boolean isDeleted) {
            this.isDeleted = isDeleted;
            return this;
        }

        @Override
        public UserNameStep withCrudId(long crudId) {
            this.crudId = crudId;
            return this;
        }

        @Override
        public AgeStep withUserName(String userName) {
            this.userName = userName;
            return this;
        }

        @Override
        public PhoneNumberStep withAge(Integer age) {
            this.age = age;
            return this;
        }

        @Override
        public AddressStep withPhoneNumber(Integer phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        @Override
        public BuildStep withAddress(String address) {
            this.address = address;
            return this;
        }

        @Override
        public Crud build() {
            return new Crud(
                    this.lastModifiedBy,
                    this.lastModified,
                    this.createdBy,
                    this.dateCreated,
                    this.isDeleted,
                    this.crudId,
                    this.userName,
                    this.age,
                    this.phoneNumber,
                    this.address
            );
        }
    }
}
