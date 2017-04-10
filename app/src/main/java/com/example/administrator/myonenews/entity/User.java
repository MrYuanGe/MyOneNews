package com.example.administrator.myonenews.entity;

/**
 * Created by Administrator on 2016/12/30.
 */

public class User {
    private String telephone;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {

        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "User{" +
                "telephone='" + telephone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
