package com.example.beauty.response;

import com.example.beauty.pojo.Ad;
import lombok.Data;

import java.util.List;

/**
 * Created by NiuLilu on 2020-04-17 9:24.
 */
@Data
public class SelectAdResponseList {
    private List<Ad> list;
    private Long total;
}
