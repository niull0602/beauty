package com.example.beauty.response;

import com.example.beauty.pojo.User;
import lombok.Data;

import java.util.List;

/**
 * Created by NiuLilu on 2020-04-13 18:43.
 */
@Data
public class SelectUserResopnseList {
    private List<User> list;
    private Long total;
}
