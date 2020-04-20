package com.example.beauty.service;

import com.example.beauty.request.AddCommentRequest;
import com.example.beauty.request.SelectCommentRequest;
import com.example.beauty.response.ProductCommentResponseList;

/**
 * Created by NiuLilu on 2020-04-20 15:11.
 */
public interface CommentService {
    Integer addComment(AddCommentRequest addCommentRequest);

    Integer deleteComment(Long commentId);

    ProductCommentResponseList selectCommentByProductId(SelectCommentRequest selectCommentRequest);
}
