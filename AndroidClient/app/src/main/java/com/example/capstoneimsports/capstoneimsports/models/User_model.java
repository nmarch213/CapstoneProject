package com.example.capstoneimsports.capstoneimsports.models;

import android.net.Uri;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;
import java.util.Date;

/**
 * Created by Nick on 2/2/2016.
 */
public class User_model {


    public static boolean connected = false;

    private static String userId;
    private static String username;
    private static String email;
    private static String firstName;
    private static String lastName;
    private static String dateOfBirth;
    private static String classLevel;
    private static String favSport;
    private static Uri _imageURI;
    private static boolean isOfficial;

    public User_model(String userId, String email, String username, String firstName, String lastName, String dateOfBirth, String classLevel, String favSport, Uri _imageURI, boolean isOfficial) {

        User_model.userId = userId;
        User_model.email = email;
        User_model.username = username;
        User_model.firstName = firstName;
        User_model.lastName = lastName;
        User_model.dateOfBirth = dateOfBirth;
        User_model.classLevel = classLevel;
        User_model.favSport = favSport;
        User_model._imageURI = _imageURI;
        User_model.isOfficial = isOfficial;
    }

    //Default Constructor
    public User_model(){
        User_model.username = "";
        User_model.email = "";
        User_model.firstName = "";
        User_model.lastName = "";
        User_model.dateOfBirth = "";
        User_model.classLevel = "";
        User_model.favSport = "";
        User_model._imageURI = null;
        User_model.isOfficial = false;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        User_model.email = email;
    }

    public static String getUsername() {
        return username;
    }

    public static void setName(String username) {
        User_model.username = username;
    }

    public static String getFirstName() { return firstName; }

    public static void setFirstName(String firstName) { User_model.firstName = firstName; }

    public static String getLastName() { return lastName; }

    public static void setLastName(String lastName) { User_model.lastName = lastName; }

    public static Uri getImageURI() { return _imageURI; }

    public static void setImageURI(Uri _imageURI) { User_model._imageURI = _imageURI; }

    public static boolean getIsOfficial() { return isOfficial; }

    public static void setIsOfficial(boolean isOfficial) { User_model.isOfficial = isOfficial;}

    public static String getFavSport() { return favSport; }

    public static void setFavSport(String favSport) { User_model.favSport = favSport; }

    public static String getClassLevel() { return classLevel; }

    public static void setClassLevel(String classLevel) { User_model.classLevel = classLevel; }

    public static String getDateOfBirth() { return dateOfBirth; }

    public static void setDateOfBirth(String dateOfBirth) {User_model.dateOfBirth = dateOfBirth; }

    public static String getUserId() { return userId; }

    public static void setUserId(String userId) { User_model.userId = userId; }

    public static boolean isConnected() {
        return connected;
    }

    public static void setConnected(boolean connected) {
        User_model.connected = connected;
    }
}
