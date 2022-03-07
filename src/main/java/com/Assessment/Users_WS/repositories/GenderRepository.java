package com.Assessment.Users_WS.repositories;

import com.Assessment.Users_WS.models.Gender;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRepository extends CrudRepository<Gender, Integer>{
    
}
