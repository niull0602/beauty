package com.example.beauty.request;

import lombok.Data;

/**
 * Created by NiuLilu on 2020-04-13 18:43.
 */
@Data
public class SelectRequest {
    private Integer pageNumber=1;
    private Integer pageSize=10;
}
