package com.example.beauty.service.impl;

import com.example.beauty.dao.PayDao;
import com.example.beauty.pojo.Pay;
import com.example.beauty.request.PayRequest;
import com.example.beauty.request.UpdatePayRequest;
import com.example.beauty.service.PayService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by NiuLilu on 2020-04-20 14:55.
 */
@Service
public class PayServiceImpl implements PayService {
    @Autowired
    private PayDao payDao;

    @Override
    public Integer addPay(PayRequest payRequest) {
        Pay pay = new Pay();
        BeanUtils.copyProperties(payRequest,pay);
        pay.setCreateTime(new Date());
        pay.setUpdateTime(new Date());
        return payDao.addPay(pay);
    }

    @Override
    public Integer update(UpdatePayRequest updatePayRequest) {
        Pay pay = new Pay();
        BeanUtils.copyProperties(updatePayRequest,pay);
        pay.setUpdateTime(new Date());
        return payDao.update(pay);
    }
}
