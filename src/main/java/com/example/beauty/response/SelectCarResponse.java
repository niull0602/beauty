package com.example.beauty.response;

import com.example.beauty.pojo.Product;
import lombok.Data;

import java.util.List;

/**
 * Created by NiuLilu on 2020-04-19 22:42.
 */
@Data
public class SelectCarResponse {
    private Long id;

    private Long numbers;

    private Double totalPrice;

    private Long productId;

    private Product product;

}
