package com.example.beauty.request;

import lombok.Data;


import java.util.Date;

/**
 * Created by NiuLilu on 2020-04-20 10:50.
 */
@Data
public class AddOrderRequest {
    private Long userId;


    private Long productId;

    /**
     * 购买数量
     */
    private Integer num;


    private Double totalPrice;

    /**
     * 订单状态
     */
    private Short status;

}
