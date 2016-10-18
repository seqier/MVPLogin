package com.example.seqier.mvplogin.model;

import android.util.Log;

import com.example.seqier.mvplogin.bean.UserBean;

/**
 * Created by seqier on 2016/10/18.
 */

public class UserModel implements IUserModel {


    private final static String TAG = "UserModel";


    @Override
    public void login(final String username, final String password, final OnLoginListener mOnLoginListener) {


        Log.d(TAG, username);
        Log.d(TAG, password);


        new Thread(

                new Runnable() {
                    @Override
                    public void run() {


                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        Log.d(TAG, "login......");

                        if ("admin".equals(username) && "admin".equals(password)) {

                            Log.d(TAG, "loginSuccess");

                            UserBean mUserBean = new UserBean();
                            mUserBean.setUsername(username);
                            mUserBean.setPassword(password);

                            mOnLoginListener.loginSuccess(mUserBean);


                        } else {

                            Log.d(TAG, "loginFailed");

                            mOnLoginListener.loginFailed();
                        }


                    }
                }

        ).start();


    }


}
