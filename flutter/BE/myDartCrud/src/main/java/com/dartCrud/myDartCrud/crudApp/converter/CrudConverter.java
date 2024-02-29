package com.dartCrud.myDartCrud.crudApp.converter;


import com.dartCrud.myDartCrud.crudApp.domain.Crud;
import com.dartCrud.myDartCrud.crudApp.dto.CrudDto;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CrudConverter {

    public Crud convertFrom(CrudDto crudDto){
        if(Objects.isNull(crudDto)){
            return null;
        }
        return Crud.Builder.crud()
                .withLastModifiedBy(crudDto.getLastModifiedBy())
                .withLastModified(crudDto.getLastModified())
                .withCreatedBy(crudDto.getCreatedBy())
                .withDateCreated(crudDto.getDateCreated())
                .withIsDeleted(crudDto.getIsDeleted())
                .withCrudId(crudDto.getCrudId())
                .withUserName(crudDto.getUserName())
                .withAge(crudDto.getAge())
                .withPhoneNumber(crudDto.getPhoneNumber())
                .withAddress(crudDto.getAddress())
                .build();
    }
    public CrudDto convertTo(Crud crud){
        if(Objects.isNull(crud)){
            return null;
        }
        return CrudDto.Builder.crudDto()
                .withDateCreated(crud.getDateCreated())
                .withLastModified(crud.getLastModified())
                .withCreatedBy(crud.getCreatedBy())
                .withLastModifiedBy(crud.getLastModifiedBy())
                .withIsDeleted(crud.getIsDeleted())
                .withCrudId(crud.getCrudId())
                .withUserName(crud.getUserName())
                .withAge(crud.getAge())
                .withPhoneNumber(crud.getPhoneNumber())
                .withAddress(crud.getAddress())
                .build();
    }
}
