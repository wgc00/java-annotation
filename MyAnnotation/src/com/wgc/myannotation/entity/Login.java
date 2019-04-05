package com.wgc.myannotation.entity;

import com.wgc.myannotation.annotation.Email;
import com.wgc.myannotation.annotation.Password;

public class Login {


    @Email
    private String email;

    @Password
    private String password;



    public Login() {}
    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }






    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
