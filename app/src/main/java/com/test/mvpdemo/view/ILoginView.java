package com.test.mvpdemo.view;

/**
 * Created by xxl on 2017/5/4.
 */

public interface ILoginView {
    void clearText();

    void showLoginSuccess();

    void showUsernameError();

    void showPasswordError();

    void showLoginError();

    void showErrorMessage();
}
