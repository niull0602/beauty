package com.example.beauty.service.impl;

import com.example.beauty.dao.CarDao;
import com.example.beauty.pojo.Car;
import com.example.beauty.request.AddCarRequest;
import com.example.beauty.request.SelectCarRequest;
import com.example.beauty.request.UpdateCarRequest;
import com.example.beauty.response.SelectCarResponse;
import com.example.beauty.response.SelectCarResponseList;
import com.example.beauty.service.CarService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by NiuLilu on 2020-04-19 22:07.
 */
@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarDao carDao;


    @Override
    public Integer addCar(AddCarRequest addCarRequest) {
        Car car = new Car();
        BeanUtils.copyProperties(addCarRequest,car);
        car.setCreateTime(new Date());
        car.setUpdateTime(new Date());
        return carDao.addCar(car);
    }

    @Override
    public Integer deleteById(Long carId) {
        return carDao.delete(carId);
    }

    @Override
    public Integer updateCar(UpdateCarRequest updateCarRequest) {
        Car car = new Car();
        BeanUtils.copyProperties(updateCarRequest,car);
        car.setUpdateTime(new Date());
        return carDao.update(car);
    }

    @Override
    public Integer updateByList(List<Car> carList) {
        return carDao.updateByList(carList);
    }

    @Override
    public SelectCarResponseList selectCarByUserId(SelectCarRequest selectCarRequest) {
        PageHelper.startPage(selectCarRequest.getPageNumber(),selectCarRequest.getPageSize());
        List<SelectCarResponse> selectCarResponses = carDao.selectCarByUserId(selectCarRequest.getUserId());
        PageInfo<SelectCarResponse> selectCarResponsePageInfo = new PageInfo<>(selectCarResponses);
        SelectCarResponseList selectCarResponseList = new SelectCarResponseList();
        selectCarResponseList.setList(selectCarResponsePageInfo.getList());
        selectCarResponseList.setTotal(selectCarResponsePageInfo.getTotal());
        return selectCarResponseList;
    }

    @Override
    public Integer deleteByIds(List<Long> ids) {
        return carDao.deleteByIds(ids);
    }
}
