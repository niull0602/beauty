package com.example.beauty.pojo;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import javax.persistence.*;

@Data
@ToString
@Table(name = "t_user")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")

    private Long id;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String password;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "nick_name")
    private String nickName;

    private String name;

    private String sex;

    private Integer age;

    private String address;

    private String job;

    @Column(name = "exist_money")
    private Double existMoney;

    /**
     * 消费次数
     */
    private Integer consumption;
    /**
     * 0:用户
     * 1：管理员
     */
    private Short mark;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    }