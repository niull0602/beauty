package com.example.beauty.dao;

import com.example.beauty.mapper.ItemBeauticianShipMapper;
import com.example.beauty.pojo.ItemBeauticianShip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:Fengxutong
 * @Date:2020/4/18
 * @Description:小冯同学写点注释吧！
 */
@Repository
public class ItemBeauticianShipDao {
    @Autowired
    ItemBeauticianShipMapper itemBeauticianShipMapper;
    public Integer addItemBeauticianShip(List<ItemBeauticianShip> itemBeauticianShipList){
        return itemBeauticianShipMapper.insertList(itemBeauticianShipList);
    }
}
