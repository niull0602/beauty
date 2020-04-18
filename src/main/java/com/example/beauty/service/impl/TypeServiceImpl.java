package com.example.beauty.service.impl;

import com.example.beauty.dao.TypeDao;
import com.example.beauty.pojo.Type;
import com.example.beauty.request.AddTypeRequest;
import com.example.beauty.response.TypeResponse;
import com.example.beauty.service.TypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lemon on 2020-02-19 11:50.
 */
@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeDao typeDao;

    @Override
    public Integer add(AddTypeRequest request) {
        Type type = new Type();
        BeanUtils.copyProperties(request,type);
        return typeDao.insert(type);
    }

    @Override
    public Integer deleteTpyeById(Long id) {
        return typeDao.deleteTpyeById(id);
    }

    @Override
    public TypeResponse getItemType(Long id) {
        TypeResponse typeResponse = new TypeResponse();
        Type type = typeDao.getTypeById(id);
        List<Type> itemType = typeDao.getItemType(type.getCode());
        typeResponse.setList(itemType);
        return typeResponse;
    }

    @Override
    public TypeResponse getType() {
        TypeResponse typeResponse = new TypeResponse();
        List<Type> type = typeDao.getType();
        typeResponse.setList(type);
        return typeResponse;
    }

    @Override
    public TypeResponse getProductType(Long id) {
        TypeResponse typeResponse = new TypeResponse();
        Type type = typeDao.getTypeById(id);
        List<Type> productType = typeDao.getProductType(type.getCode());
        typeResponse.setList(productType);
        return typeResponse;
    }
}
