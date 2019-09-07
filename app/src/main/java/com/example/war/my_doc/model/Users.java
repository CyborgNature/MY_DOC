package com.example.war.my_doc.model;

/**
 * Created by war on 1/28/2018.
 */

public class Users {

    String Name;
    String Phone;
    String Password;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Users() {

    }

    public Users(String name, String phone, String password) {
        Name = name;
        Phone = phone;
        Password = password;
    }
}