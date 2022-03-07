package com.Assessment.Users_WS.controllers;

import com.Assessment.Users_WS.models.Response;
import com.Assessment.Users_WS.models.User;
import com.Assessment.Users_WS.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService service;

    @GetMapping("/getAll")
    public Response getAllUsers() {
        return service.getAllUsers();
    }

    @DeleteMapping("/delete/{idUser}")
    public Response deleteById(@PathVariable("idUser") Integer idUser) {
        return service.deleteUserById(idUser);
    }

    @PostMapping("/saveUser")
    public Response saveUser(
            @RequestBody User user) {
        return service.saveUser(user);
    }

    @GetMapping("/login")
    public Response login(
        @RequestBody User user
    ){
        return service.login(user);
    }
}
