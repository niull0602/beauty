package com.example.beauty.response;

import com.example.beauty.pojo.User;
import lombok.Data;

/**
 * Created by lemon on 2020-02-23 22:58.
 */
@Data
public class LoginResponse {
    private User user;

    private String msg;

    private String token;
}
