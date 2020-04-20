package com.example.beauty.dao;

import com.example.beauty.mapper.OrdersMapper;
import com.example.beauty.pojo.Orders;
import com.example.beauty.response.SelectAdminOrdersResponse;
import com.example.beauty.response.SelectOrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by NiuLilu on 2020-04-20 9:34.
 */
@Repository
public class OrdersDao {
    @Autowired
    private OrdersMapper ordersMapper;


    public Integer addOrder(Orders orders) {
        return ordersMapper.insert(orders);
    }

    public Integer deleteOrderById(Long orderId) {
        return ordersMapper.deleteByPrimaryKey(orderId);
    }

    public Integer deleteOrderByIds(List<Long> ids){
        Example example = new Example(Orders.class);
        example.createCriteria()
                .andIn("id",ids);
        return ordersMapper.deleteByExample(example);
    }

    public Integer updateOrder(Orders orders) {
        return ordersMapper.updateByPrimaryKeySelective(orders);
    }


    public List<Orders> selectAll() {
        return ordersMapper.selectAll();
    }

    public List<SelectOrderResponse> selectOrdersByUserId(Long userId) {
        return ordersMapper.selectOrdersByUserId(userId);
    }

    public List<SelectAdminOrdersResponse> selectOrdersAdmin() {
        return ordersMapper.selectOrdersAdmin();
    }
}
