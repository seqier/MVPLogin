package com.example.seqier.mvplogin.model;

/**
 * Created by seqier on 2016/10/18.
 */

public interface IUserModel {

    public void login(String username, String password, OnLoginListener mOnLoginListener);

}
