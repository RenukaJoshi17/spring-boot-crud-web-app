package com.example.crud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import com.example.model.Crud;

import com.example.crud.Entity.*;

@Repository
public interface CRUDRepository extends JpaRepository<User, Long>{
	

}

