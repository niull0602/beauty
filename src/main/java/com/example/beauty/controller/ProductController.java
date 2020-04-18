package com.example.beauty.controller;

import com.example.beauty.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by NiuLilu on 2020-04-18 14:58.
 */
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

}
