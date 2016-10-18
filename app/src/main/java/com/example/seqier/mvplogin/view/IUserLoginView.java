package com.example.seqier.mvplogin.view;

import com.example.seqier.mvplogin.bean.UserBean;

/**
 * Created by seqier on 2016/10/18.
 */

public interface IUserLoginView {

    String getUserName();

    String getPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(UserBean userModel);

    void showFailedError();

    void clearUserName();

    void clearPassword();

}
