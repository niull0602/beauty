package com.example.beauty.controller;

import com.example.beauty.common.SzpJsonResult;
import com.example.beauty.request.AddCommentRequest;
import com.example.beauty.request.SelectCommentRequest;
import com.example.beauty.response.ProductCommentResponseList;
import com.example.beauty.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by NiuLilu on 2020-04-20 15:10.
 */
@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping(value = "add/comment")
    public SzpJsonResult<Integer> addComment(@RequestBody AddCommentRequest addCommentRequest){
        return SzpJsonResult.ok(commentService.addComment(addCommentRequest));
    }

    @DeleteMapping(value = "delete/comment/{commentId}")
    public SzpJsonResult<Integer> deleteComment(@PathVariable(value = "commentId") Long commentId){
        return SzpJsonResult.ok(commentService.deleteComment(commentId));
    }

    @PostMapping(value = "select/comment/productId")
    public SzpJsonResult<ProductCommentResponseList> selectCommentByProductId(@RequestBody SelectCommentRequest selectCommentRequest){
        return SzpJsonResult.ok(commentService.selectCommentByProductId(selectCommentRequest));
    }



}
