package com.example.beauty.dao;

import com.example.beauty.mapper.PayMapper;
import com.example.beauty.pojo.Pay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by NiuLilu on 2020-04-20 14:55.
 */
@Repository
public class PayDao {
    @Autowired
    private PayMapper payMapper;


    public Integer addPay(Pay pay) {
        return payMapper.insert(pay);
    }

    public Integer update(Pay pay) {
        return payMapper.updateByPrimaryKeySelective(pay);
    }
}
