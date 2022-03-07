package com.Assessment.Users_WS.services;

import java.util.ArrayList;

import com.Assessment.Users_WS.models.Response;
import com.Assessment.Users_WS.models.User;
import com.Assessment.Users_WS.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository repository;
    @Autowired
    ProfileService profileService;

    public Response getAllUsers() {
        Response response = new Response();
        try {
            ArrayList<User> usersList = (ArrayList<User>) repository.findAll();
            response.setUsersList(usersList);
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

    public Response deleteUserById(Integer idUser) {
        Response response = new Response();
        try {
            repository.deleteById(idUser);
            response.setCode(200);
            response.setError(false);
            Singleton s = Singleton.getInstance();
            response.setMessage(s.getMessage());
            return response;
        } catch (Exception e) {
            response.setCode(400);
            response.setError(true);
            response.setMessage("There is no an suser with that id");
            return response;
        }
    }

    public Response saveUser(User user) {
        Response response = new Response();
        if (user.getLogin() == null || user.getPassword() == null || user.getUserName() == null
                || user.getPassword() == "" || user.getUserName() == "" || user.getProfile() == null
                || user.getIdEmployee() == null || user.getStatus() == null) {
            response.setCode(400);
            response.setError(true);
            response.setMessage("The values can not be null or empty");
            return response;
        }
        if (isUserNameUsed(user.getUserName())) {
            response.setCode(400);
            response.setError(true);
            response.setMessage("The user is already used");
            return response;
        }
        Response auxResponse = profileService.getProfileById(user.getProfile().getIdProfile());
        if (auxResponse.isError()) {
            response.setCode(400);
            response.setError(true);
            response.setMessage("The profile used does not exist");
            return response;
        }
        try {
            User auxUser = repository.save(user);
            response.setCode(200);
            response.setError(false);
            Singleton s = Singleton.getInstance();
            response.setMessage(s.getMessage());
            response.setUser(auxUser);
            return response;
        } catch (Exception ex) {
            response.setCode(400);
            response.setError(true);
            response.setMessage("There was an error in the database");
            return response;
        }
    }

    public boolean isUserNameUsed(String userName) {
        ArrayList<User> list = repository.findByUserName(userName);
        if (list.size() > 0) {
            return true;
        }
        return false;
    }

    public Response login(User user) {
        Response response = new Response();
        if (user.getPassword() == null || user.getUserName() == null
                || user.getPassword() == "" || user.getUserName() == "") {
            response.setCode(400);
            response.setError(true);
            response.setMessage("The user and password can not be null or empty");
            return response;
        }
        try {
            ArrayList<User> list = repository.findByUserName(user.getUserName());
            if (list.size() > 0) {
                User auxUser = list.get(0);
                if (user.getPassword().equals(auxUser.getPassword())) {
                    response.setCode(200);
                    response.setError(false);
                    Singleton s = Singleton.getInstance();
                    response.setMessage(s.getMessage());
                    response.setUser(auxUser);
                    return response;
                }
            }
            response.setCode(400);
            response.setError(true);
            response.setMessage("The credentials are incorrect");
            return response;
        } catch (Exception e) {
            response.setCode(400);
            response.setError(true);
            response.setMessage("There was an error in the database");
            return response;
        }

    }
}
