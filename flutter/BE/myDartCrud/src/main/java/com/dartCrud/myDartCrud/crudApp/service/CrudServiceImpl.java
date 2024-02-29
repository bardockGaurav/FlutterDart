package com.dartCrud.myDartCrud.crudApp.service;

import com.dartCrud.myDartCrud.crudApp.common.Constants;
import com.dartCrud.myDartCrud.crudApp.converter.CrudConverter;
import com.dartCrud.myDartCrud.crudApp.domain.Crud;
import com.dartCrud.myDartCrud.crudApp.dto.CrudDto;
import com.dartCrud.myDartCrud.crudApp.repository.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import java.util.Objects;


@Service
public class CrudServiceImpl implements CrudService{
    @Autowired
    private CrudRepository crudRepository;
    @Autowired
    private CrudConverter crudConverter;

    @Override
    public CrudDto saveOrUpdate(CrudDto crudDto) {
        Crud crud = crudRepository.findByCrudId(crudDto.getCrudId());
        if(ObjectUtils.isEmpty(crud)){
            crudDto.setDateCreated(System.currentTimeMillis());
            crudDto.setCreatedBy(Constants.SYSTEM);
            crudDto.setLastModified(System.currentTimeMillis());
            crudDto.setLastModifiedBy(Constants.SYSTEM);
            crud = crudConverter.convertFrom(crudDto);
        }
        if(Objects.nonNull(crudDto.getUserName())){
            crud.setUserName(crudDto.getUserName());
        }
        if(Objects.nonNull(crudDto.getAge())){
            crud.setAge(crudDto.getAge());
        }
        if(Objects.nonNull(crudDto.getPhoneNumber())){
            crud.setPhoneNumber(crudDto.getPhoneNumber());
        }
        if(Objects.nonNull(crudDto.getAddress())){
            crud.setAddress(crudDto.getAddress());
        }
        crud.setLastModified(System.currentTimeMillis());
        crud.setLastModifiedBy(Constants.SYSTEM);

        crud = crudRepository.save(crud);

        return crudConverter.convertTo(crud);
    }


    @Override
    public String deleteById(long crudId) {
        Crud crud=crudRepository.findByCrudId(crudId);
        crudRepository.delete(crud);

        return "Successfully Delete";
    }

    @Override
    public CrudDto fetchById(long crudId) {
        Crud crud = crudRepository.findByCrudId(crudId);
        return crudConverter.convertTo(crud);
    }
    }

