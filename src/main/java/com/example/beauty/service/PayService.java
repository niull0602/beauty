package com.example.beauty.service;

import com.example.beauty.request.PayRequest;
import com.example.beauty.request.UpdatePayRequest;

/**
 * Created by NiuLilu on 2020-04-20 14:55.
 */
public interface PayService {
    Integer addPay(PayRequest payRequest);

    Integer update(UpdatePayRequest updatePayRequest);
}
