package com.example.beauty.controller;

import com.example.beauty.common.SzpJsonResult;
import com.example.beauty.request.AddItemRequest;
import com.example.beauty.request.SelectItemByTypeRequest;
import com.example.beauty.request.SelectRequest;
import com.example.beauty.request.UpdateItemRequest;
import com.example.beauty.response.SelectItemResponseList;
import com.example.beauty.service.ItemService;
import com.example.beauty.service.impl.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author:Fengxutong
 * @Date:2020/4/18
 * @Description:小冯同学写点注释吧！
 */
@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;


    @PostMapping(value = "add/item")
    public SzpJsonResult<Integer> addItem(@RequestBody AddItemRequest addItemRequest) {
        return SzpJsonResult.ok(itemService.addItem(addItemRequest));
    }

    @DeleteMapping(value = "delete/{itemId}")
    public SzpJsonResult<Integer> deleteItem(@PathVariable(value = "itemId")Long itemId){
        return SzpJsonResult.ok(itemService.deleteItem(itemId));
    }

    @PutMapping(value = "update/item")
    public SzpJsonResult<Integer> updateItem(@RequestBody UpdateItemRequest updateItemRequest){
        return SzpJsonResult.ok(itemService.updateItem(updateItemRequest));
    }

    @PostMapping(value = "select/all/item")
    public SzpJsonResult<SelectItemResponseList> selectAll(@RequestBody SelectRequest selectRequest){
        return SzpJsonResult.ok(itemService.selectAllItem(selectRequest));
    }

    @PostMapping(value = "select/item/by/type")
    public SzpJsonResult<SelectItemResponseList> selectItemByType(@RequestBody SelectItemByTypeRequest selectRequest){
        return SzpJsonResult.ok(itemService.selectItemByTypes(selectRequest));
    }


}
