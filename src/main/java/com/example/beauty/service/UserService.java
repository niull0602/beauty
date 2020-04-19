package com.example.beauty.service;

import com.example.beauty.request.*;
import com.example.beauty.response.*;


/**
 * Created by NiuLilu on 2020-04-13 16:57.
 */
public interface UserService {
    String saveCode(String phoneNumber);

    String getCode(String phoneNumber);

    LoginResponse login(LoginRequest loginRequest);

    LoginResponse loginBySms(LoginUserBySmsRequest loginUserBySmsRequest);

    Integer deleteUser(Long userId);

    Integer addUser(AddUserRequest request);

    SelectUserResponse findUserById(Long id);

    SelectUserResopnseList selectAll(SelectRequest request);

    Integer updateUser(UpdateUserRequest updateUserRequest);

    Integer exits(String phoneNumber);
}
