package com.Assessment.Users_WS.services;

public class Singleton {

    private static Singleton instance;
    private static String message = "Working...";

    private Singleton(){
        
    }

    public static Singleton getInstance(){
        if(instance==null){
            instance = new Singleton();
        }
        return instance;
    }

    public String getMessage(){
        return message;
    }
}
