package com.Assessment.Users_WS.repositories;

import java.util.ArrayList;

import com.Assessment.Users_WS.models.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
    public abstract ArrayList<User> findByUserName(String userName);
}
