package com.assignment.android.service;

import com.assignment.android.dto.AccessTokenDto;
import com.assignment.android.dto.LoginFormDto;
import com.assignment.android.exception.CustomGlobalException;

public interface UserService {
    AccessTokenDto authenticateAccount(LoginFormDto request) throws CustomGlobalException;
}
