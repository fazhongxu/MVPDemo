package com.test.mvpdemo.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.test.mvpdemo.R;
import com.test.mvpdemo.presenter.LoginPresenterImpl;

public class LoginActivity extends AppCompatActivity implements ILoginView, View.OnClickListener {

    private EditText mUsername;
    private EditText mPassword;
    private LoginPresenterImpl loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        mUsername = (EditText) findViewById(R.id.et_username);
        mPassword = (EditText) findViewById(R.id.et_pwd);
        findViewById(R.id.btn_clear).setOnClickListener(this);
        findViewById(R.id.btn_login).setOnClickListener(this);
        loginPresenter = new LoginPresenterImpl(this);
    }

    @Override
    public void clearText() {
        Toast.makeText(LoginActivity.this, "清除", Toast.LENGTH_SHORT).show();
        mUsername.setText("");
        mPassword.setText("");
    }

    @Override
    public void showLoginSuccess() {
        Toast.makeText(this, "用户名密码验证成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUsernameError() {
        Toast.makeText(this, "用户名错误", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showPasswordError() {
        Toast.makeText(this, "密码错误", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showLoginError() {
        Toast.makeText(this, "登录失败，可能是网络问题", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(this, "用户名或密码不正确", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                loginPresenter.doLogin(mUsername.getText().toString(), mPassword.getText().toString());
                break;
            case R.id.btn_clear:
                loginPresenter.clear();
                break;
        }
    }
}
