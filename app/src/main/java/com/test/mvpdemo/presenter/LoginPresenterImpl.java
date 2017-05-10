package com.test.mvpdemo.presenter;

import android.os.Handler;
import android.text.TextUtils;

import com.test.mvpdemo.model.UserModel;
import com.test.mvpdemo.view.ILoginView;

/**
 * Created by xxl on 2017/5/4.
 */

public class LoginPresenterImpl implements ILoginPresenter {
    private ILoginView iLoginView;
    private UserModel userModel;
    private String mUsername;
    private String mPassword;

    public LoginPresenterImpl(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        initUser();
    }

    @Override
    public void clear() {
        if (iLoginView != null) {
            iLoginView.clearText();
        }
    }

    @Override
    public void doLogin(final String username, final String password) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (iLoginView != null) {
                    if (TextUtils.isEmpty(username)) {
                        iLoginView.showUsernameError();
                        return;
                    }
                    if (TextUtils.isEmpty(password)) {
                        iLoginView.showPasswordError();
                        return;
                    }
                    if (mUsername.equals(username) && mPassword.equals(password)) {
                        iLoginView.showLoginSuccess();
                    } else {
                        iLoginView.showErrorMessage();
                    }
                }
            }
        }, 3000);
    }

    private void initUser() {
        userModel = new UserModel("xxx", "ooo");
        mUsername = userModel.getUsername();
        mPassword = userModel.getPassword();
    }

}
