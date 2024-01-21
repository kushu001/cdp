package com.chomolungma.auth.login.application.service;

public interface LoginService {
    String login(String username, String password);

    void resetPassword(String oldPassword, String newPassword, String confirmPassword);
}
