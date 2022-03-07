package com.Assessment.Users_WS.services;

import java.util.ArrayList;

import com.Assessment.Users_WS.models.Gender;
import com.Assessment.Users_WS.models.Response;
import com.Assessment.Users_WS.repositories.GenderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenderService {

    @Autowired
    GenderRepository repository;

    public Response getAllGenders() {
        Response r = new Response();
        try {
            ArrayList<Gender> gendersList = (ArrayList<Gender>) repository.findAll();
            r.setGendersList(gendersList);
            r.setCode(200);
            r.setError(false);
            Singleton s = Singleton.getInstance();
            r.setMessage(s.getMessage());
            return r;
        } catch (Exception e) {
            r.setCode(400);
            r.setError(true);
            r.setMessage("There was an error in the database");
            return r;
        }
    }

}
