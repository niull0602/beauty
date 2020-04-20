package com.example.beauty.service.impl;

import com.example.beauty.dao.CommentDao;
import com.example.beauty.pojo.Comment;
import com.example.beauty.request.AddCommentRequest;
import com.example.beauty.request.SelectCommentRequest;
import com.example.beauty.response.ProductCommentResponse;
import com.example.beauty.response.ProductCommentResponseList;
import com.example.beauty.service.CommentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by NiuLilu on 2020-04-20 15:11.
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;

    @Override
    public Integer addComment(AddCommentRequest addCommentRequest) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(addCommentRequest,comment);
        comment.setCreateTime(new Date());
        comment.setUpdateTime(new Date());
        return commentDao.addComment(comment);
    }

    @Override
    public Integer deleteComment(Long commentId) {
        return commentDao.deleteComment(commentId);
    }

    @Override
    public ProductCommentResponseList selectCommentByProductId(SelectCommentRequest selectCommentRequest) {
        ProductCommentResponseList productCommentResponseList = new ProductCommentResponseList();
        PageHelper.startPage(selectCommentRequest.getPageNumber(),selectCommentRequest.getPageSize());
        List<ProductCommentResponse> commentList = commentDao.selectCommentByProductId(selectCommentRequest.getProductId());
        PageInfo<ProductCommentResponse> pageInfo = new PageInfo<>(commentList);
        productCommentResponseList.setList(pageInfo.getList());
        productCommentResponseList.setTotal(pageInfo.getTotal());
        return productCommentResponseList;
    }
}
