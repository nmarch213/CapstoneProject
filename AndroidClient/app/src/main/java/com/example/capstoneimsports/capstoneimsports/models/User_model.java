package com.example.capstoneimsports.capstoneimsports.models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Nick on 2/2/2016.
 */
public class User_model {


    public static boolean connected = false;

    private static String username;
    private static String email;
    private static String firstName;
    private static String lastName;
    private static String password;


    public User_model(String email, String username, String firstName, String lastName) {

        User_model.email = email;
        User_model.username = username;
        User_model.firstName = firstName;
        User_model.lastName = lastName;
    }

    public User_model(){
        username = "";
        email = "";
        firstName = "";
        lastName = "";
    }

    public static JSONObject newUser(User_model user) throws JSONException {

        JSONObject json = new JSONObject("{'email': " + email + "'password': " + password + " }");

        return json;
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


    public static boolean isConnected() {
        return connected;
    }

    public static void setConnected(boolean connected) {
        User_model.connected = connected;
    }
}
