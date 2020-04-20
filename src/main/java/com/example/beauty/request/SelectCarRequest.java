package com.example.beauty.request;

import lombok.Data;

/**
 * Created by NiuLilu on 2020-04-19 22:40.
 */
@Data
public class SelectCarRequest {
    private Long userId;

    private Integer pageNumber=1;

    private Integer pageSize=10;
}
