package com.test.mvpdemo.model;

/**
 * Created by xxl on 2017/5/4.
 * 用户实体类
 */

public class UserModel implements IUser {

    private String username;
    private String password;

    public UserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }
}
