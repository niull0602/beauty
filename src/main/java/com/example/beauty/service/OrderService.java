package com.example.beauty.service;

import com.example.beauty.request.AddOrderRequest;
import com.example.beauty.request.SelectOrderRequest;
import com.example.beauty.request.SelectRequest;
import com.example.beauty.request.UpdateOrderRequest;
import com.example.beauty.response.SelectAdminOrdersResponseList;
import com.example.beauty.response.SelectOrderResponseList;

import java.util.List;

/**
 * Created by NiuLilu on 2020-04-20 9:53.
 */
public interface OrderService {
    Integer addOrder(AddOrderRequest addOrderRequest);

    Integer deleteOrderById(Long orderId);

    Integer deleteOrderByIds(List<Long> orderIds);

    Integer updateOrder(UpdateOrderRequest addOrderRequest);

    SelectOrderResponseList selectOrdersByUserId(SelectOrderRequest selectRequest);

    SelectAdminOrdersResponseList selectOrdersAdmin(SelectRequest selectRequest);
}
