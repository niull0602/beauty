package com.example.beauty.pojo;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import javax.persistence.*;


@Table(name = "t_beautician")
@Data
@Entity
public class Beautician {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    private String name;

    private Integer age;

    private String sex;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "beautician_desc")
    private String beauticianDesc;

    /**
     * 入职时间？计算工作年限
     */
    @Column(name = "working_time")
    private Date workingTime;

    /**
     * 等级
     */
    private Integer grader;

    /**
     * 薪水
     */
    private Double salary;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

}