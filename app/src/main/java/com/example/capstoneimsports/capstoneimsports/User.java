package com.example.capstoneimsports.capstoneimsports;

/**
 * Created by Nick on 2/2/2016.
 */
public class User {

    String name, username, password;
    int age;

    public User(String username, String password)
    {
        this.username = username;
        this.password = password;
        this.age = -1;
        this.name = "";
    }
}
