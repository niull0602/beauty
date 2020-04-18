package com.example.beauty.controller;

import com.example.beauty.common.SzpJsonResult;
import com.example.beauty.request.AddBeauticianRequest;
import com.example.beauty.request.SelectRequest;
import com.example.beauty.request.UpdateBeauticianRequest;
import com.example.beauty.response.SelectBeauticianResponseList;
import com.example.beauty.service.BeauticianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created byNiuLilu on 2020-04-17 9:55.
 */
@RestController
public class BeauticianController {
    @Autowired
    private BeauticianService beauticianService;

    @PostMapping(value = "add/beautician")
    public SzpJsonResult<Integer> addBeautician(@RequestBody AddBeauticianRequest addBeauticianRequest){
        return SzpJsonResult.ok(beauticianService.addBeautician(addBeauticianRequest));
    }

    @DeleteMapping(value = "delete/beautician/{id}")
    public SzpJsonResult<Integer> deleteBeautician(@PathVariable(value = "id") Long id){
        return SzpJsonResult.ok(beauticianService.deleteBeautician(id));
    }

    @PutMapping(value = "update/beautician")
    public SzpJsonResult<Integer> updateBeautician(@RequestBody UpdateBeauticianRequest updateBeauticianRequest){
        return SzpJsonResult.ok(beauticianService.updateBeautician(updateBeauticianRequest));
    }

    @PostMapping(value = "select/all/beautician")
    public SzpJsonResult<SelectBeauticianResponseList> selectAllBeautician(@RequestBody SelectRequest selectRequest){
        return SzpJsonResult.ok(beauticianService.selectAll(selectRequest));
    }
}
