package com.example.beauty.dao;

import com.example.beauty.mapper.BeauticianMapper;
import com.example.beauty.pojo.Beautician;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by NiuLilu on 2020-04-17 9:53.
 */
@Repository
public class BeauticianDao {
    @Autowired
    private BeauticianMapper beauticianMapper;


    public Integer add(Beautician beautician) {
        return beauticianMapper.insert(beautician);
    }


    public Integer deleteById(Long id) {
        return beauticianMapper.deleteByPrimaryKey(id);
    }

    public Integer update(Beautician beautician) {
        return beauticianMapper.updateByPrimaryKeySelective(beautician);
    }

    public List<Beautician> selectAll() {
        return beauticianMapper.selectAll();
    }
}
