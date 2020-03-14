package com.example.firebase_realtimedatabase;

public class User {

    String username,userage,userphone,userpass;

    public User() {
    }

    public User(String username, String userage, String userphone,String userpass) {
        this.username = username;
        this.userage = userage;
        this.userphone = userphone;
        this.userpass=userpass;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserage() {
        return userage;
    }

    public void setUserage(String userage) {
        this.userage = userage;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }
    public String getUserpass() {
        return userpass;
    }

    public void setUserpasse(String userphone) {
        this.userpass = userpass;
    }
}
