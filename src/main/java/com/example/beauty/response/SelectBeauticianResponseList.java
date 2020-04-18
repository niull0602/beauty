package com.example.beauty.response;

import com.example.beauty.pojo.Beautician;
import lombok.Data;

import java.util.List;

/**
 * Created by NiuLilu on 2020-04-17 10:10.
 */
@Data
public class SelectBeauticianResponseList {
    private List<Beautician> list;
    private Long total;
}
