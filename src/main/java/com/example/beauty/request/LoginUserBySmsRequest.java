package com.example.beauty.request;

import lombok.Data;

/**
 * Created by NiuLilu on 2020-04-13 18:36.
 */
@Data
public class LoginUserBySmsRequest {
    private String phoneNumber;
    private String code;
}
