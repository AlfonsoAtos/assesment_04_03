package com.Assessment.Users_WS.controllers;

import com.Assessment.Users_WS.models.Profile;
import com.Assessment.Users_WS.models.Response;
import com.Assessment.Users_WS.services.ProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profiles")
public class ProfileController {
    @Autowired
    ProfileService service;

    @GetMapping("/getAll")
    public Response getAllProfiles() {
        return service.getAllProfiles();
    }

    @PostMapping("/saveProfile")
    public Response saveProfile(
            @RequestBody Profile profile) {
        return service.saveProfile(profile);
    }

    @GetMapping("/getById/{idProfile}")
    public Response getById(@PathVariable("idProfile") Integer idProfile){
        return service.getProfileById(idProfile);
    }
    
    @DeleteMapping("/delete/{idProfile}")
    public Response deleteById(@PathVariable("idProfile") Integer idProfile){
        return service.deleteProfileById(idProfile);
    }
}
