package com.example.seqier.mvplogin.model;

import com.example.seqier.mvplogin.bean.UserBean;

/**
 * Created by seqier on 2016/10/18.
 */

public interface OnLoginListener {

    public void loginSuccess(UserBean mUserBean);

    public void loginFailed();

}
