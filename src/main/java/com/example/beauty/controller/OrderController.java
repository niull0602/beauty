package com.example.beauty.controller;

import com.example.beauty.common.SzpJsonResult;
import com.example.beauty.request.AddOrderRequest;
import com.example.beauty.request.SelectOrderRequest;
import com.example.beauty.request.SelectRequest;
import com.example.beauty.request.UpdateOrderRequest;
import com.example.beauty.response.SelectAdminOrdersResponseList;
import com.example.beauty.response.SelectOrderResponseList;
import com.example.beauty.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by NiuLilu on 2020-04-20 10:07.
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping(value = "add/order")
    public SzpJsonResult<Integer> addOrder(@RequestBody AddOrderRequest addOrderRequest){
        return SzpJsonResult.ok(orderService.addOrder(addOrderRequest));
    }

    @DeleteMapping(value = "delete/order/{id}")
    public SzpJsonResult<Integer> deleteOrderById(@PathVariable(value = "orderId")Long orderId){
        return SzpJsonResult.ok(orderService.deleteOrderById(orderId));
    }

    @DeleteMapping(value = "delete/order/ids")
    public SzpJsonResult<Integer> deleteOrderByIds(@RequestBody List<Long> orderIds){
        return SzpJsonResult.ok(orderService.deleteOrderByIds(orderIds));
    }

    @PutMapping(value = "update/order")
    public SzpJsonResult<Integer> updateOrder(@RequestBody UpdateOrderRequest addOrderRequest){
        return SzpJsonResult.ok(orderService.updateOrder(addOrderRequest));
    }

    @PostMapping(value = "select/orders/userId")
    public SzpJsonResult<SelectOrderResponseList> selectOrdersByUserId(@RequestBody SelectOrderRequest selectRequest){
        return SzpJsonResult.ok(orderService.selectOrdersByUserId(selectRequest));
    }

    @PostMapping(value = "select/orders/admin")
    public SzpJsonResult<SelectAdminOrdersResponseList> selectOrdersAdmin(@RequestBody SelectRequest selectRequest){
        return SzpJsonResult.ok(orderService.selectOrdersAdmin(selectRequest));
    }

}
