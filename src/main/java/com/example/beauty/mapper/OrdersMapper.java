package com.example.beauty.mapper;

import com.example.beauty.pojo.Orders;
import com.example.beauty.response.SelectAdminOrdersResponse;
import com.example.beauty.response.SelectOrderResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrdersMapper extends CommonMapper<Orders> {
    List<SelectOrderResponse> selectOrdersByUserId(@Param(value = "userId") Long userId);

    List<SelectAdminOrdersResponse> selectOrdersAdmin();

}