package com.example.beauty.request;

import lombok.Data;

import javax.persistence.Column;

/**
 * Created by NiuLilu on 2020-04-20 15:13.
 */
@Data
public class AddCommentRequest {
    private Long orderId;

    private Long productId;

    private Long userId;

    private String content;
}
