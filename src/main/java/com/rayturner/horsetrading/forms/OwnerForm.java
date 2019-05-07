package com.rayturner.horsetrading.forms;

public class OwnerForm {
    public String username;
    public String password;
    public String email;
    public String location;

    public OwnerForm(String username, String password, String email, String location) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.location = location;
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
        return username != null &&  password != null &&  email != null && location != null;
    }
}
