package com.example.beauty.dao;

import com.example.beauty.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by NiuLilu on 2020-04-18 14:56.
 */
@Repository
public class ProductDao {
    @Autowired
    private ProductMapper productMapper;

}
