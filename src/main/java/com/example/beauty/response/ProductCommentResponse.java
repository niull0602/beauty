package com.example.beauty.response;

import com.example.beauty.pojo.User;
import lombok.Data;

import java.util.Date;

/**
 * Created by NiuLilu on 2020-04-20 15:23.
 */
@Data
public class ProductCommentResponse {
    private Long id;

    private String content;

    private Date createTime;

    private Long userId;

    private User user;
}
