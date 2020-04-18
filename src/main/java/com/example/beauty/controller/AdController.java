package com.example.beauty.controller;

import com.example.beauty.common.SzpJsonResult;
import com.example.beauty.request.AddAdRequest;
import com.example.beauty.request.SelectRequest;
import com.example.beauty.request.UpdateAdRequest;
import com.example.beauty.response.SelectAdResponseList;
import com.example.beauty.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by NiuLilu on 2020-04-17 9:10.
 */
@RestController
public class AdController {
    @Autowired
    private AdService adService;

    @PostMapping(value = "add/ad")
    public SzpJsonResult<Integer> addAd(@RequestBody AddAdRequest addAdRequest){
        return SzpJsonResult.ok(adService.addAd(addAdRequest));
    }

    @GetMapping(value = "select/all/ad")
    public SzpJsonResult<SelectAdResponseList> selectAllAd(@RequestBody SelectRequest selectRequest){
        return SzpJsonResult.ok(adService.selectAllAd(selectRequest));
    }

    @PutMapping(value = "update/ad")
    public SzpJsonResult<Integer> updateAd(@RequestBody UpdateAdRequest updateAdRequest){
        return SzpJsonResult.ok(adService.updateAd(updateAdRequest));
    }

    @DeleteMapping(value = "delete/ad/{id}")
    public SzpJsonResult<Integer> deleteAd(@PathVariable(value = "id") Integer id){
        return SzpJsonResult.ok(adService.deleteAdById(id));
    }

    @GetMapping(value = "select/ad")
    public SzpJsonResult<SelectAdResponseList> selectAd(@RequestBody SelectRequest selectRequest){
        return SzpJsonResult.ok(adService.selectAd(selectRequest));
    }
}
