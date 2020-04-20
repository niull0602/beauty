package com.example.beauty.mapper;

import com.example.beauty.pojo.Comment;
import com.example.beauty.response.ProductCommentResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper extends CommonMapper<Comment> {
    List<ProductCommentResponse> selectCommentByProductId(@Param(value = "productId")Long productId);
}