package com.example.beauty.response;

import lombok.Data;

import java.util.List;

/**
 * Created by NiuLilu on 2020-04-20 15:36.
 */
@Data
public class ProductCommentResponseList {
    private List<ProductCommentResponse> list;
    private Long total;
}
