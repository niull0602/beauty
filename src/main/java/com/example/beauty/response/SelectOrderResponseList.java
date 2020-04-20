package com.example.beauty.response;

import lombok.Data;

import java.util.List;

/**
 * Created by NiuLilu on 2020-04-20 13:15.
 */
@Data
public class SelectOrderResponseList {
    private List<SelectOrderResponse> list;
    private Long total;
}
