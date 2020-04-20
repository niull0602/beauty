package com.example.beauty.controller;

import com.example.beauty.common.SzpJsonResult;
import com.example.beauty.request.PayRequest;
import com.example.beauty.request.UpdatePayRequest;
import com.example.beauty.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by NiuLilu on 2020-04-20 14:54.
 */
@RestController
public class PayController {
    @Autowired
    private PayService payService;

    @PostMapping(value = "order/pay")
    public SzpJsonResult<Integer> orderPay(@RequestBody PayRequest payRequest){
        return SzpJsonResult.ok(payService.addPay(payRequest));
    }

    @PutMapping(value = "update/pay")
    public SzpJsonResult<Integer> udpatePay(@RequestBody UpdatePayRequest updatePayRequest){
        return SzpJsonResult.ok(payService.update(updatePayRequest));
    }
}
