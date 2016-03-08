package com.example.capstoneimsports.capstoneimsports.models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Nick on 2/2/2016.
 */
public class User_model {


    public static boolean connected = false;

    private static String password;
    private static int age;
    private static String username;
    private static String email;


    public User_model(String email, String password, String username) {

        User_model.email = email;
        User_model.password = password;
        User_model.username = username;

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

    public static int getAge() {
        return age;
    }

    public static void setAge(int age) {
        User_model.age = age;
    }


    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        User_model.password = password;
    }

    public static boolean isConnected() {
        return connected;
    }

    public static void setConnected(boolean connected) {
        User_model.connected = connected;
    }
}
