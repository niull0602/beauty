package com.example.beauty.dao;

import com.example.beauty.mapper.CarMapper;
import com.example.beauty.pojo.Car;
import com.example.beauty.response.SelectCarResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by NiuLilu on 2020-04-19 22:05.
 */
@Repository
public class CarDao {
    @Autowired
    private CarMapper carMapper;

    public Integer addCar(Car car) {
        return carMapper.insert(car);
    }

    public Integer delete(Long carId) {
        return carMapper.deleteByPrimaryKey(carId);
    }

    public Integer deleteByIds(List<Long> ids) {
        Example example = new Example(Car.class);
        example.createCriteria()
                .andIn("id",ids);
        return carMapper.deleteByExample(example);
    }

    public Integer update(Car car) {
        return carMapper.updateByPrimaryKeySelective(car);
    }

    public Integer updateByList(List<Car> carList) {
        return carMapper.updateList(carList);
    }

    public List<Car> selectByUserId(Long userId){
        Example example = new Example(Car.class);
        example.createCriteria()
                .andEqualTo("userId",userId);
        return carMapper.selectByExample(example);
    }

    public List<SelectCarResponse> selectCarByUserId(Long userId){
        return carMapper.selectCarByUserId(userId);
    }
}
