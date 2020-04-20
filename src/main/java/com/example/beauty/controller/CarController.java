package com.example.beauty.controller;

import com.example.beauty.common.SzpJsonResult;
import com.example.beauty.request.AddCarRequest;
import com.example.beauty.request.SelectCarRequest;
import com.example.beauty.request.UpdateCarRequest;
import com.example.beauty.response.SelectCarResponseList;
import com.example.beauty.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by NiuLilu on 2020-04-19 22:08.
 */
@RestController
public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping(value = "add/car")
    public SzpJsonResult<Integer> addCar(@RequestBody AddCarRequest addCarRequest){
        return SzpJsonResult.ok(carService.addCar(addCarRequest));
    }

    @DeleteMapping(value = "delete/car/{carId}")
    public SzpJsonResult<Integer> deleteCar(@PathVariable(value = "carId")Long carId){
        return SzpJsonResult.ok(carService.deleteById(carId));
    }

    @DeleteMapping(value = "delete/car/ids")
    public SzpJsonResult<Integer> deleteCarByIds(@RequestBody List<Long> ids){
        return SzpJsonResult.ok(carService.deleteByIds(ids));
    }

    @PutMapping(value = "update/car")
    public SzpJsonResult<Integer> updateCar(@RequestBody UpdateCarRequest updateCarRequest){
        return SzpJsonResult.ok(carService.updateCar(updateCarRequest));
    }

    @PostMapping(value = "select/car/by/userId")
    public SzpJsonResult<SelectCarResponseList> selectCarByUserId(@RequestBody SelectCarRequest selectCarRequest){
        return SzpJsonResult.ok(carService.selectCarByUserId(selectCarRequest));
    }

}
