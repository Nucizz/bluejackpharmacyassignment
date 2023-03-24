package com.example.bluejackpharmacy.object;

import static androidx.core.content.ContextCompat.startActivity;

import com.example.bluejackpharmacy.activity.HomeActivity;

import java.util.Base64;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private String phone;

    public User(int id, String name, String email, String password, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public static User currentUser;

    public static void setUser(User user){
        currentUser = user;
    }

    public static String hashPassword(String text) {
        return Base64.getEncoder().encodeToString(text.getBytes());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHashed() {
        return password;
    }

    public void setPassword(String password) {
        this.password = hashPassword(password);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
