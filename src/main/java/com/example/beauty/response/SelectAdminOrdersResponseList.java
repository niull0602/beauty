package com.example.beauty.response;

import lombok.Data;

import java.util.List;

/**
 * Created by NiuLilu on 2020-04-20 18:15.
 */
@Data
public class SelectAdminOrdersResponseList {
    private List<SelectAdminOrdersResponse> list;
    private Long total;
}
