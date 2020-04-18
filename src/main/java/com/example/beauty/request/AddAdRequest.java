package com.example.beauty.request;

import lombok.Data;

import java.util.Date;

/**
 * Created by NiuLilu on 2020-04-17 9:15.
 */
@Data
public class AddAdRequest {
    /**
     * 发布者id
     */
    private Long userId;

    /**
     * 标题
     */
    private String title;

    /**
     * 图片文件名
     */

    private String imgFileName;

    /**
     * 发布内容
     */
    private String spotContent;

    /**
     * 外链地址
     */
    private String link;

    private Short status;

    private Date beginTime;

    private Date endTime;
}
