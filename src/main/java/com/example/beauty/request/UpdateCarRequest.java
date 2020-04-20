package com.example.beauty.request;

import lombok.Data;

/**
 * Created by NiuLilu on 2020-04-19 22:14.
 */
@Data
public class UpdateCarRequest {
    private Long id;

    private Long userId;

    private Long productId;

    private Long numbers;

    private Double totalPrice;
    /**
     * 下单之后对应商品就不应该显示在购物车了
     */
    private Short status;
}
