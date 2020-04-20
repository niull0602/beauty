package com.example.beauty.service;

import com.example.beauty.pojo.Car;
import com.example.beauty.request.AddCarRequest;
import com.example.beauty.request.SelectCarRequest;
import com.example.beauty.request.UpdateCarRequest;
import com.example.beauty.response.SelectCarResponseList;

import java.util.List;

/**
 * Created by NiuLilu on 2020-04-19 22:07.
 */
public interface CarService {
    Integer addCar(AddCarRequest addCarRequest);

    Integer deleteById(Long carId);

    Integer deleteByIds(List<Long> ids);

    Integer updateCar(UpdateCarRequest updateCarRequest);

    Integer updateByList(List<Car> carList);

    SelectCarResponseList selectCarByUserId(SelectCarRequest selectCarRequest);
}
