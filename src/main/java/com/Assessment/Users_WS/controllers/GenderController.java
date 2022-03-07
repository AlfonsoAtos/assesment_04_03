package com.Assessment.Users_WS.controllers;

import com.Assessment.Users_WS.models.Response;
import com.Assessment.Users_WS.services.GenderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/genders")
public class GenderController {
    @Autowired
    GenderService service;

    @GetMapping("/getAll")
    public Response getAll() {
        return service.getAllGenders();
    }
}
