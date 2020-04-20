package com.example.beauty.dao;

import com.example.beauty.mapper.CommentMapper;
import com.example.beauty.pojo.Comment;
import com.example.beauty.response.ProductCommentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by NiuLilu on 2020-04-20 15:10.
 */
@Repository
public class CommentDao {
    @Autowired
    private CommentMapper commentMapper;

    public Integer addComment(Comment comment) {
        return commentMapper.insert(comment);
    }

    public Integer deleteComment(Long commentId) {
        return commentMapper.deleteByPrimaryKey(commentId);
    }

    public List<ProductCommentResponse> selectCommentByProductId(Long productId) {
        return commentMapper.selectCommentByProductId(productId);
    }
}
