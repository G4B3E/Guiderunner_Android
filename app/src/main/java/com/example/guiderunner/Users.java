package com.example.guiderunner;

public class Users {
    private String accountname;
    private String email;
    private String password;

    public Users(String accountname, String email, String password) {
        this.accountname = accountname;
        this.email = email;
        this.password = password;
    }

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname;
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
