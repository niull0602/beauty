package com.example.beauty.controller;

import com.example.beauty.common.SzpJsonResult;
import com.example.beauty.request.AddProductRequest;
import com.example.beauty.request.SelectProductByTypeRequest;
import com.example.beauty.request.SelectRequest;
import com.example.beauty.request.UpdateProductRequest;
import com.example.beauty.response.SelectProductResponseList;
import com.example.beauty.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by NiuLilu on 2020-04-18 14:58.
 */
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping(value = "add/product")
    private SzpJsonResult<Integer> addProduct(@RequestBody AddProductRequest addProductRequest){
        return SzpJsonResult.ok(productService.addProduct(addProductRequest));
    }

    @DeleteMapping(value = "delete/product/{id}")
    private SzpJsonResult<Integer> deleteProduct(@PathVariable(value = "id")Long id){
        return SzpJsonResult.ok(productService.deleteProduct(id));
    }

    @PutMapping(value = "update/product")
    private SzpJsonResult<Integer> updateProduct(@RequestBody UpdateProductRequest updateProductRequest){
        return SzpJsonResult.ok(productService.updateProduct(updateProductRequest));
    }

    @PostMapping(value = "select/all/product")
    public SzpJsonResult<SelectProductResponseList> selectProductResponseList(@RequestBody SelectRequest selectRequest){
        return SzpJsonResult.ok(productService.selectAllProduct(selectRequest));
    }

    @PostMapping(value = "select/product/by/type")
    public SzpJsonResult<SelectProductResponseList> selectProductByTypes(@RequestBody SelectProductByTypeRequest selectRequest){
        return SzpJsonResult.ok(productService.selectProductByTypes(selectRequest));
    }


}
