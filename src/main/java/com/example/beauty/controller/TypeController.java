package com.example.beauty.controller;


import com.example.beauty.common.SzpJsonResult;
import com.example.beauty.request.AddTypeRequest;
import com.example.beauty.response.TypeResponse;
import com.example.beauty.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lemon on 2020-02-19 11:49.
 */
@RestController
public class TypeController {
    @Autowired
    private TypeService typeService;

    @GetMapping(value = "get/type")
    public SzpJsonResult<TypeResponse> getType(){
        return SzpJsonResult.ok(typeService.getType());
    }

    @GetMapping(value = "get/item/type")
    public SzpJsonResult<TypeResponse> getItemType(@PathVariable(value = "id")Long id){
        return SzpJsonResult.ok(typeService.getItemType(id));
    }

    @GetMapping(value = "get/product/type")
    public SzpJsonResult<TypeResponse> getProductType(@PathVariable(value = "id")Long id){
        return SzpJsonResult.ok(typeService.getProductType(id));
    }

    @PostMapping(value = "add/type")
    public SzpJsonResult<Integer> addTpye(@RequestBody AddTypeRequest request){
        return SzpJsonResult.ok(typeService.add(request));
    }

    @DeleteMapping(value = "delete/type/{id}")
    public SzpJsonResult<Integer> deleteTpyeById(@PathVariable(value = "id")Long id){
        return SzpJsonResult.ok(typeService.deleteTpyeById(id));
    }



}
