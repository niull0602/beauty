package com.example.beauty.dao;

import com.example.beauty.mapper.ItemBeauticianShipMapper;
import com.example.beauty.pojo.ItemBeauticianShip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Author:Fengxutong
 * @Date:2020/4/18
 * @Description:小冯同学写点注释吧！
 */
@Repository
public class ItemBeauticianShipDao {
    @Autowired
    private ItemBeauticianShipMapper itemBeauticianShipMapper;
    public Integer addItemBeauticianShip(List<ItemBeauticianShip> itemBeauticianShipList){
        return itemBeauticianShipMapper.insertList(itemBeauticianShipList);
    }

    public List<ItemBeauticianShip> selectByItemId(Long itemId) {
        Example example = new Example(ItemBeauticianShip.class);
        example.createCriteria()
                .andEqualTo("itemId",itemId);
        return itemBeauticianShipMapper.selectByExample(example);
    }

    public Integer delete(Long id){
        return itemBeauticianShipMapper.deleteByPrimaryKey(id);
    }

    public Integer deleteByList(List<Long> IdList) {
        Example example = new Example(ItemBeauticianShip.class);
        example.createCriteria()
        .andIn("id",IdList);
        return itemBeauticianShipMapper.deleteByExample(example);
    }
}
