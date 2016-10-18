package com.example.seqier.mvplogin.presenter;

import android.os.Handler;

import com.example.seqier.mvplogin.bean.UserBean;
import com.example.seqier.mvplogin.model.OnLoginListener;
import com.example.seqier.mvplogin.model.UserModel;
import com.example.seqier.mvplogin.view.IUserLoginView;

/**
 * Created by seqier on 2016/10/18.
 */

public class UserLoginPresenter implements OnLoginListener {

    UserModel mUserModel = new UserModel();

    private Handler mHandler = new Handler();


    private IUserLoginView mIUserLoginView;

    public UserLoginPresenter(IUserLoginView mIUserLoginView) {
        this.mIUserLoginView = mIUserLoginView;

    }

    public void login() {


        mIUserLoginView.showLoading();

        String username = mIUserLoginView.getUserName();
        String password = mIUserLoginView.getPassword();

        mUserModel.login(username, password, this);

    }

    @Override
    public void loginSuccess(final UserBean mUserBean) {


        //需要在UI线程执行
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                mIUserLoginView.toMainActivity(mUserBean);
                mIUserLoginView.hideLoading();
            }
        });

    }

    @Override
    public void loginFailed() {
        //需要在UI线程执行
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                mIUserLoginView.showFailedError();
                mIUserLoginView.hideLoading();
            }
        });

    }

    public void clear() {

        //需要在UI线程执行
        mHandler.post(new Runnable() {
            @Override
            public void run() {

                mIUserLoginView.clearUserName();
                mIUserLoginView.clearPassword();

            }
        });

    }
}
