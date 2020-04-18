package com.example.beauty.request;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

/**
 * Created by NiuLilu on 2020-04-17 9:57.
 */
@Data
public class AddBeauticianRequest {
    private String name;

    private Integer age;

    private String sex;

    private String phoneNumber;

    private String imgUrl;

    private String beauticianDesc;

    /**
     * 入职时间？计算工作年限
     */
    private Date workingTime;

    /**
     * 等级
     */
    private Integer grader;

    /**
     * 薪水
     */
    private Double salary;
}
