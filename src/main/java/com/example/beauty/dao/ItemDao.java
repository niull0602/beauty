package com.example.beauty.dao;

import com.example.beauty.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by NiuLilu on 2020-04-18 14:25.
 */
@Repository
public class ItemDao {
    @Autowired
    private ItemMapper itemMapper;

}
