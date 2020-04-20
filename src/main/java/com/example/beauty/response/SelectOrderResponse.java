package com.example.beauty.response;

import com.example.beauty.pojo.Product;
import lombok.Data;

/**
 * Created by NiuLilu on 2020-04-20 13:23.
 */
@Data
public class SelectOrderResponse {
    private Long id;

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

    private Product product;
}
