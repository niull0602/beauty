package com.example.beauty.request;


import lombok.Data;

import java.util.Date;


/**
 * Created by NiuLilu on 2020-03-07 14:31.
 */
@Data
public class AddUserRequest  {
    private String phoneNumber;

    private String password;

    private String imgUrl;

    private String nickName;

    private String name;

    private String sex;

    private Integer age;

    private String address;

    private String job;

    private Double existMoney;

    /**
     * 消费次数
     */
    private Integer consumption;

    private Short mark=0;


}
