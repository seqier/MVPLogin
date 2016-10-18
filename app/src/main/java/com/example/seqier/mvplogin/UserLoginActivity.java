package com.example.seqier.mvplogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.seqier.mvplogin.bean.UserBean;
import com.example.seqier.mvplogin.presenter.UserLoginPresenter;
import com.example.seqier.mvplogin.view.IUserLoginView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserLoginActivity extends AppCompatActivity implements IUserLoginView {

    UserLoginPresenter mUserLoginPresenter = new UserLoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        ButterKnife.bind(this);

    }

    @Bind(R.id.button1)
    Button login;

    @Bind(R.id.button2)
    Button clear;

    @Bind(R.id.editText1)
    TextView username;

    @Bind(R.id.editText2)
    TextView password;

    @Bind(R.id.progressBar)
    ProgressBar mPbLoading;


    @OnClick(R.id.button1)
    public void login() {
        mUserLoginPresenter.login();
    }

    @OnClick(R.id.button2)
    public void clear() {
        mUserLoginPresenter.clear();
    }


    @Override
    public String getUserName() { return username.getText().toString(); }

    @Override
    public String getPassword() {
        return password.getText().toString();
    }

    @Override
    public void showLoading() { mPbLoading.setVisibility(View.VISIBLE); }

    @Override
    public void hideLoading() {
        mPbLoading.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(UserBean userModel) {
        Toast.makeText(this, userModel.getUsername() + " login success , to MainActivity", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(UserLoginActivity.this, MainActivity.class);
        startActivity(i);
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this, "login failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clearUserName() {
        username.setText("");
    }

    @Override
    public void clearPassword() {
        password.setText("");
    }
}
