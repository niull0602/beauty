package com.example.beauty.service;

import com.example.beauty.request.AddTypeRequest;
import com.example.beauty.response.TypeResponse;

/**
 * Created by lemon on 2020-02-19 11:49.
 */
public interface TypeService {

    Integer add(AddTypeRequest request);

    Integer deleteTpyeById(Long id);

    TypeResponse getItemType(Long id);

    TypeResponse getType();

    TypeResponse getProductType(Long id);

}
