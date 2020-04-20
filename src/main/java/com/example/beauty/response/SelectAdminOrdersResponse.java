package com.example.beauty.response;

import com.example.beauty.pojo.User;
import lombok.Data;

/**
 * Created by NiuLilu on 2020-04-20 18:15.
 */
@Data
public class SelectAdminOrdersResponse {
    private Long id;

    private Long userId;


    private Long productId;

    private String  productName;

    /**
     * 购买数量
     */
    private Integer num;


    private Double totalPrice;

    /**
     * 订单状态
     */
    private Short status;

    private User user;

    private Long payId;
}
