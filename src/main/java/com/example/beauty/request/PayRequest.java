package com.example.beauty.request;

import lombok.Data;

/**
 * Created by NiuLilu on 2020-04-20 14:57.
 */
@Data
public class PayRequest {
    private Long userId;

    private Double payPrice;

    private Short payStatus;
}
