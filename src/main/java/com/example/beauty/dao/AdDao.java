package com.example.beauty.dao;

import com.example.beauty.mapper.AdMapper;
import com.example.beauty.pojo.Ad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by NiuLilu on 2020-04-17 9:11.
 */
@Repository
public class AdDao {
    @Autowired
    private AdMapper adMapper;

    public Integer addAd(Ad ad) {
        return adMapper.insert(ad);
    }

    public List<Ad> selectAll() {
        return adMapper.selectAll();
    }

    public Integer updateAd(Ad ad) {
        return adMapper.updateByPrimaryKeySelective(ad);
    }

    public Integer deleteAdById(Integer id) {
        return adMapper.deleteByPrimaryKey(id);
    }

    public List<Ad> selectAd() {
        Example example = new Example(Ad.class);
        example.createCriteria()
                .orNotEqualTo("status",0);
        return adMapper.selectByExample(example);
    }
}
