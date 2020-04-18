package com.example.beauty.request;

import lombok.Data;

/**
 * Created by NiuLilu on 2020-04-13 17:17.
 */
@Data
public class LoginRequest {
    private String phoneNumber;

    private String password;
}
