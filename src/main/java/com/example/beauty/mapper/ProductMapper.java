package com.example.beauty.mapper;

import com.example.beauty.pojo.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper extends CommonMapper<Product> {
}