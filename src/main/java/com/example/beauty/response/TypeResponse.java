package com.example.beauty.response;

import com.example.beauty.pojo.Type;
import lombok.Data;

import java.util.List;

/**
 * Created by NiuLilu on 2020-04-18 14:34.
 */
@Data
public class TypeResponse {
    List<Type> list;
    Long total;
}
