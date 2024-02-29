package com.dartCrud.myDartCrud.crudApp.dto;


import com.dartCrud.myDartCrud.crudApp.common.AbstractEntityInfo;

public class CrudDto extends AbstractEntityInfo {

    private long crudId;
    private String userName;
    private Integer age;
    private Integer phoneNumber;
    private String address;

    public CrudDto(){}

    public CrudDto(Long dateCreated, Long lastModified, String createdBy, String lastModifiedBy, Boolean isDeleted, long crudId, String userName, Integer age, Integer phoneNumber, String address) {
        super(dateCreated, lastModified, createdBy, lastModifiedBy, isDeleted);
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

    public static interface DateCreatedStep {
        LastModifiedStep withDateCreated(Long dateCreated);
    }

    public static interface LastModifiedStep {
        CreatedByStep withLastModified(Long lastModified);
    }

    public static interface CreatedByStep {
        LastModifiedByStep withCreatedBy(String createdBy);
    }

    public static interface LastModifiedByStep {
        IsDeletedStep withLastModifiedBy(String lastModifiedBy);
    }

    public static interface IsDeletedStep {
        CrudIdStep withIsDeleted(Boolean isDeleted);
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
        CrudDto build();
    }

    public static class Builder implements DateCreatedStep, LastModifiedStep, CreatedByStep, LastModifiedByStep, IsDeletedStep, CrudIdStep, UserNameStep, AgeStep, PhoneNumberStep, AddressStep, BuildStep {
        private Long dateCreated;
        private Long lastModified;
        private String createdBy;
        private String lastModifiedBy;
        private Boolean isDeleted;
        private long crudId;
        private String userName;
        private Integer age;
        private Integer phoneNumber;
        private String address;

        private Builder() {
        }

        public static DateCreatedStep crudDto() {
            return new Builder();
        }

        @Override
        public LastModifiedStep withDateCreated(Long dateCreated) {
            this.dateCreated = dateCreated;
            return this;
        }

        @Override
        public CreatedByStep withLastModified(Long lastModified) {
            this.lastModified = lastModified;
            return this;
        }

        @Override
        public LastModifiedByStep withCreatedBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        @Override
        public IsDeletedStep withLastModifiedBy(String lastModifiedBy) {
            this.lastModifiedBy = lastModifiedBy;
            return this;
        }

        @Override
        public CrudIdStep withIsDeleted(Boolean isDeleted) {
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
        public CrudDto build() {
            return new CrudDto(
                    this.dateCreated,
                    this.lastModified,
                    this.createdBy,
                    this.lastModifiedBy,
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
