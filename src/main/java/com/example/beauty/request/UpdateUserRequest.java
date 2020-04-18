package com.example.beauty.request;

import lombok.Data;

import java.util.Date;

@Data
public class UpdateUserRequest {
    private Long id;

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


    private Date updateTime;

}
