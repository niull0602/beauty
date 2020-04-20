package com.example.beauty.request;

import lombok.Data;

/**
 * Created by NiuLilu on 2020-04-20 15:39.
 */
@Data
public class SelectCommentRequest {
    private Long productId;
    private Integer pageNumber=1;
    private Integer pageSize=10;
}
