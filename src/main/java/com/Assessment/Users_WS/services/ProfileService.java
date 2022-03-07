package com.Assessment.Users_WS.services;

import java.util.ArrayList;

import com.Assessment.Users_WS.models.Profile;
import com.Assessment.Users_WS.models.Response;
import com.Assessment.Users_WS.repositories.ProfileRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    ProfileRepository repository;

    public Response getAllProfiles() {
        Response response = new Response();
        try {
            ArrayList<Profile> profilesList = (ArrayList<Profile>) repository.findAll();
            response.setProfilesList(profilesList);
            response.setCode(200);
            response.setError(false);
            Singleton s = Singleton.getInstance();
            response.setMessage(s.getMessage());
            return response;
        } catch (Exception e) {
            response.setCode(400);
            response.setError(true);
            response.setMessage("There was an error in the database");
            return response;
        }
    }

    public Response saveProfile(Profile profile) {
        Response response = new Response();
        if (profile.getProfile() == null || profile.getProfile() == "") {
            response.setCode(400);
            response.setError(true);
            response.setMessage("The value of profile can not be null or empty");
            return response;
        }
        if (existsProfileDescription(profile.getProfile())) {
            response.setCode(400);
            response.setError(true);
            response.setMessage("The value of profile already exists");
            return response;
        }
        try {
            Profile auxProfile = repository.save(profile);
            response.setCode(200);
            response.setError(false);
            response.setMessage("The profile was saved/updated successfully");
            response.setProfile(auxProfile);
            return response;
        } catch (Exception ex) {
            response.setCode(400);
            response.setError(true);
            response.setMessage("There was an error in the database");
            return response;
        }
    }

    public Response getProfileById(Integer idProfile) {
        Response response = new Response();
        if (idProfile == null) {
            response.setCode(400);
            response.setError(true);
            response.setMessage("The id can not be null");
            return response;
        }
        try {
            ArrayList<Profile> profilesList = repository.findByIdProfile(idProfile);
            if (profilesList.size() > 0) {
                response.setProfile(profilesList.get(0));
                response.setCode(200);
                response.setError(false);
                Singleton s = Singleton.getInstance();
                response.setMessage(s.getMessage());
                return response;
            }
            response.setCode(400);
            response.setError(true);
            response.setMessage("There is no profile with that id");
            return response;
        } catch (Exception e) {
            response.setCode(400);
            response.setError(true);
            response.setMessage("There was an error in the database");
            return response;
        }
    }

    public boolean existsProfileDescription(String profile) {
        ArrayList<Profile> list = repository.findByProfile(profile);
        if (list.size() > 0) {
            return true;
        }
        return false;
    }

    public Response deleteProfileById(Integer idProfile) {
        Response response = new Response();
        try {
            repository.deleteById(idProfile);
            response.setCode(200);
            response.setError(false);
            Singleton s = Singleton.getInstance();
            response.setMessage(s.getMessage());
            return response;
        } catch (Exception e) {
            response.setCode(400);
            response.setError(true);
            response.setMessage("There is no profile with that id");
            return response;
        }
    }
}
