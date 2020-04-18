package com.example.beauty.service.impl;

import com.example.beauty.dao.ProductDao;
import com.example.beauty.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by NiuLilu on 2020-04-18 14:57.
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

}
