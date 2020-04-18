package com.example.beauty.controller;

import com.example.beauty.common.SzpJsonResult;
import com.example.beauty.request.*;
import com.example.beauty.response.LoginResponse;
import com.example.beauty.response.SelectUserResopnseList;
import com.example.beauty.response.SelectUserResponse;
import com.example.beauty.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by NiuLilu on 2020-04-13 16:55.
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "login")
    public SzpJsonResult<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        return SzpJsonResult.ok(userService.login(loginRequest));
    }

    @PostMapping("login/sms")
    public SzpJsonResult<LoginResponse> loginBySms(@RequestBody LoginUserBySmsRequest request){
        return SzpJsonResult.ok(userService.loginBySms(request));
    }

    @PostMapping(value = "add/user")
    public SzpJsonResult<Integer> addUser(@RequestBody AddUserRequest addUserRequest){
        return SzpJsonResult.ok(userService.addUser(addUserRequest));
    }

    @DeleteMapping(value = "delete/user/{userId}")
    public SzpJsonResult<Integer> deleteUser(@PathVariable(value = "userId") Long userId){
        return SzpJsonResult.ok(userService.deleteUser(userId));
    }

    @PutMapping(value = "update/user")
    public SzpJsonResult<Integer> updateUser(@RequestBody UpdateUserRequest updateUserRequest){
        return SzpJsonResult.ok(userService.updateUser(updateUserRequest));
    }

    @GetMapping(value = "select/user/{id}")
    public SzpJsonResult<SelectUserResponse> selectUserById(@PathVariable(value = "id")Long id){
        return SzpJsonResult.ok(userService.findUserById(id));
    }

    @PostMapping(value = "select/all/user")
    public SzpJsonResult<SelectUserResopnseList> selectAllUser(@RequestBody SelectRequest request){
        return SzpJsonResult.ok(userService.selectAll(request));
    }

    @GetMapping(value = "exits/user")
    public SzpJsonResult<Integer> exitsUser(@RequestParam(value = "phoneNumber")String phoneNumber){
        return SzpJsonResult.ok(userService.exits(phoneNumber));
    }

    @GetMapping(value = "get/sms/code")
    public SzpJsonResult<String> getCode(@RequestParam(value = "phoneNumber")String phoneNumber){
        return SzpJsonResult.ok(userService.getCode(phoneNumber));
    }

    @PostMapping(value = "send/code")
    public SzpJsonResult<String> sendCode(@RequestParam(value = "phoneNumber")String phoneNumber){
        return SzpJsonResult.ok(userService.saveCode(phoneNumber));
    }
}
