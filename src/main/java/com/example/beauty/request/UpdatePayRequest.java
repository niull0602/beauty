package com.example.beauty.request;

import lombok.Data;

/**
 * Created by NiuLilu on 2020-04-20 15:07.
 */
@Data
public class UpdatePayRequest {
    private Long id;

    private Long userId;

    private Double payPrice;

    private Short payStatus;
}
