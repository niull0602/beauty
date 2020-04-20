package com.example.beauty.request;

import lombok.Data;

/**
 * Created by NiuLilu on 2020-04-20 12:42.
 */
@Data
public class UpdateOrderRequest {
    private Long id;

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

    private Long payId;
}
