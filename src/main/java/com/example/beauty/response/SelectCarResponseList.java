package com.example.beauty.response;

import lombok.Data;

import java.util.List;

/**
 * Created by NiuLilu on 2020-04-19 22:40.
 */
@Data
public class SelectCarResponseList {
    private List<SelectCarResponse> list;

    private Long total;
}
