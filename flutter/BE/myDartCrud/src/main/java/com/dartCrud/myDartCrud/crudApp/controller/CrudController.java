package com.dartCrud.myDartCrud.crudApp.controller;


import com.dartCrud.myDartCrud.crudApp.dto.CrudDto;
import com.dartCrud.myDartCrud.crudApp.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/crud")
public class CrudController {

    @Autowired
    private CrudService crudService;

    @PutMapping("/saveUpdate")
    public CrudDto saveOrUpdate(@RequestBody CrudDto crudDto) {
        return crudService.saveOrUpdate(crudDto);
    }

    @DeleteMapping("/delete")
    public String deleteById(@RequestParam long crudId) {
        crudService.deleteById(crudId);
        return "Successfully";
    }

    @GetMapping("/fetch")
    public CrudDto fetchByCrudId(@RequestParam long crudId) {
        return crudService.fetchById(crudId);
    }
}
