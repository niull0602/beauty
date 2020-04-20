package com.example.beauty.mapper;

import com.example.beauty.pojo.Car;
import com.example.beauty.response.SelectCarResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CarMapper extends CommonMapper<Car> {
    Integer updateList(@Param(value = "list") List<Car> carList);
    List<SelectCarResponse> selectCarByUserId(@Param(value = "userId") Long userId);
}