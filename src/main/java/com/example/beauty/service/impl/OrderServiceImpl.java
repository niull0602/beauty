package com.example.beauty.service.impl;


import com.example.beauty.constant.BeautyConstant;
import com.example.beauty.dao.OrdersDao;
import com.example.beauty.dao.PayDao;
import com.example.beauty.dao.ProductDao;
import com.example.beauty.pojo.Orders;
import com.example.beauty.pojo.Pay;
import com.example.beauty.pojo.Product;
import com.example.beauty.request.AddOrderRequest;
import com.example.beauty.request.SelectOrderRequest;
import com.example.beauty.request.SelectRequest;
import com.example.beauty.request.UpdateOrderRequest;
import com.example.beauty.response.SelectAdminOrdersResponse;
import com.example.beauty.response.SelectAdminOrdersResponseList;
import com.example.beauty.response.SelectOrderResponse;
import com.example.beauty.response.SelectOrderResponseList;
import com.example.beauty.service.OrderService;
import com.example.beauty.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


/**
 * Created by NiuLilu on 2020-04-20 9:53.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrdersDao ordersDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private PayDao payDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer addOrder(AddOrderRequest addOrderRequest) {
        Orders orders = new Orders();
        Product product = productDao.selectProductById(addOrderRequest.getProductId());
        product.setExistNumber(product.getExistNumber()-addOrderRequest.getNum());
        product.setSaleNumber(product.getSaleNumber()+addOrderRequest.getNum());
        productDao.updateProduct(product);
        BeanUtils.copyProperties(addOrderRequest,orders);
        orders.setCreateTime(new Date());
        orders.setUpdateTime(new Date());
        /*Pay pay = new Pay();
        pay.setUserId(addOrderRequest.getUserId());
        pay.setUpdateTime(new Date());
        pay.setCreateTime(new Date());
        pay.setPayPrice(addOrderRequest.getTotalPrice());
        pay.setPayStatus(BeautyConstant.PAY_SUCCESS);
        payDao.addPay(pay);*/
        return ordersDao.addOrder(orders);
    }

    @Override
    public Integer deleteOrderById(Long orderId) {
        return ordersDao.deleteOrderById(orderId);
    }

    @Override
    public Integer deleteOrderByIds(List<Long> orderIds) {
        return ordersDao.deleteOrderByIds(orderIds);
    }

    @Override
    public Integer updateOrder(UpdateOrderRequest addOrderRequest) {
        Orders orders = new Orders();
        BeanUtils.copyProperties(addOrderRequest,orders);
        orders.setUpdateTime(new Date());
        return ordersDao.updateOrder(orders);
    }

    @Override
    public SelectOrderResponseList selectOrdersByUserId(SelectOrderRequest selectRequest) {
        PageHelper.startPage(selectRequest.getPageNumber(),selectRequest.getPageSize());
        List<SelectOrderResponse> orderResponseList = ordersDao.selectOrdersByUserId(selectRequest.getUserId());
        PageInfo<SelectOrderResponse> pageInfo = new PageInfo<>(orderResponseList);
        SelectOrderResponseList selectOrderResponseList = new SelectOrderResponseList();
        selectOrderResponseList.setList(pageInfo.getList());
        selectOrderResponseList.setTotal(pageInfo.getTotal());
        return selectOrderResponseList;
    }

    @Override
    public SelectAdminOrdersResponseList selectOrdersAdmin(SelectRequest selectRequest) {
        SelectAdminOrdersResponseList selectAdminOrdersResponseList = new SelectAdminOrdersResponseList();
        PageHelper.startPage(selectRequest.getPageNumber(),selectRequest.getPageSize());
        List<SelectAdminOrdersResponse> adminOrdersResponseList = ordersDao.selectOrdersAdmin();
        PageInfo<SelectAdminOrdersResponse> pageInfo = new PageInfo<>(adminOrdersResponseList);
        selectAdminOrdersResponseList.setList(pageInfo.getList());
        selectAdminOrdersResponseList.setTotal(pageInfo.getTotal());
        return selectAdminOrdersResponseList;
    }


}
