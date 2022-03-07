package com.Assessment.Users_WS.models;

import java.util.ArrayList;

public class Response {
    
    private boolean error;
    private Integer code;
    private String message;
    private ArrayList<Profile> profilesList;
    private Profile profile;
    private ArrayList<User> usersList;
    private User user;
    private ArrayList<Gender> gendersList;

    public Profile getProfile() {
        return profile;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public ArrayList<User> getUsersList() {
        return usersList;
    }
    public void setUsersList(ArrayList<User> usersList) {
        this.usersList = usersList;
    }
    public boolean isError() {
        return error;
    }
    public void setError(boolean error) {
        this.error = error;
    }
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public ArrayList<Profile> getProfilesList() {
        return profilesList;
    }
    public void setProfilesList(ArrayList<Profile> profilesList) {
        this.profilesList = profilesList;
    }
    public void setProfile(Profile profile) {
        this.profile = profile;
    }
    public void setGendersList(ArrayList<Gender> gendersList) {
        this.gendersList = gendersList;
    }
    public ArrayList<Gender> getGendersList(){
        return gendersList;
    }
}
