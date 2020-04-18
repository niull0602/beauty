package com.example.beauty.pojo;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

import javax.persistence.*;

@Table(name = "t_ad")
@Data
@Entity
public class Ad {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer id;

    /**
     * 发布者id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 标题
     */
    private String title;

    /**
     * 图片文件名
     */
    @Column(name = "img_file_name")
    private String imgFileName;

    /**
     * 发布内容
     */
    @Column(name = "spot_content")
    private String spotContent;

    /**
     * 外链地址
     */
    private String link;

    @Column(name = "begin_time")
    private Date beginTime;

    @Column(name = "end_time")
    private Date endTime;

    private Short status;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;
}