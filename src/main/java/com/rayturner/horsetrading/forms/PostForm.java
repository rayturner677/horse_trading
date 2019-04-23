package com.rayturner.horsetrading.forms;

public class PostForm {
    public Integer id;
    public String username;
    public String password;
    public String email;
    public String location;

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean is_valid(){
        return  username != null && location != null  && email != null;
    }
}
