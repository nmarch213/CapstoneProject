package com.example.capstoneimsports.capstoneimsports.models;

/**
 * Created by Nick on 2/2/2016.
 */
public class User {


    public static boolean connected = false;

    private static String password;
    private static int age;
    private static String name;
    private static String email;



    public User(String email, String password)
    {
        User.email = email;
        User.password = password;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        User.email = email;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        User.name = name;
    }

    public static int getAge() {
        return age;
    }

    public static void setAge(int age) {
        User.age = age;
    }


    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        User.password = password;
    }

    public static boolean isConnected() {
        return connected;
    }

    public static void setConnected(boolean connected) {
        User.connected = connected;
    }
}
