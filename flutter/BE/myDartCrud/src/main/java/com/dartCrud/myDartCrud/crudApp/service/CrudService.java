package com.dartCrud.myDartCrud.crudApp.service;


import com.dartCrud.myDartCrud.crudApp.dto.CrudDto;

public interface CrudService {

    CrudDto saveOrUpdate(CrudDto crudDto);

    String deleteById(long crudId);

    CrudDto fetchById(long crudId);
}
