package com.dartCrud.myDartCrud.crudApp.repository;


import com.dartCrud.myDartCrud.crudApp.domain.Crud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudRepository extends JpaRepository<Crud, Long> {

    Crud findByCrudId(long crudId);
}
