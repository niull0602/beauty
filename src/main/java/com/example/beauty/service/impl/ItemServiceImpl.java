package com.example.beauty.service.impl;

import com.example.beauty.bo.ImgBo;
import com.example.beauty.dao.ItemBeauticianShipDao;
import com.example.beauty.dao.ItemDao;
import com.example.beauty.pojo.Item;
import com.example.beauty.pojo.ItemBeauticianShip;
import com.example.beauty.request.AddItemRequest;
import com.example.beauty.request.SelectItemByTypeRequest;
import com.example.beauty.request.SelectRequest;
import com.example.beauty.request.UpdateItemRequest;
import com.example.beauty.response.SelectItemResponse;
import com.example.beauty.response.SelectItemResponseList;
import com.example.beauty.service.ItemService;
import com.example.beauty.utils.JsonUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.netty.util.internal.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @Author:Fengxutong
 * @Date:2020/4/18
 * @Description:小冯同学写点注释吧！
 */
@Service
@Slf4j
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private ItemBeauticianShipDao itemBeauticianShipDao;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer addItem(AddItemRequest addItemRequest) {
        Item item = new Item();
        item.setCreateTime(new Date());
        BeanUtils.copyProperties(addItemRequest,item);
        List<String> imgsUrl = addItemRequest.getImgsUrl();
        if (!CollectionUtils.isEmpty(imgsUrl)){
            HashMap<String,String> hashMap = new HashMap<>();
            for (String string :imgsUrl) {
                hashMap.put(UUID.randomUUID().toString(),string);
            }
            String s = JsonUtils.objectToJson(hashMap);
            item.setImgsUrl(s);
        }
        item.setUpdateTime(new Date());
        item.setCreateTime(new Date());
        itemDao.addItem(item);
        List<Long> beauticianId = addItemRequest.getBeauticianId();
        log.info("BeauticianId",beauticianId);
        List<ItemBeauticianShip> itemBeauticianShipList = new ArrayList<>();
        for (Long bId:beauticianId) {
            ItemBeauticianShip itemBeauticianShip = new ItemBeauticianShip();
            itemBeauticianShip.setItemId(item.getId());
            itemBeauticianShip.setBeauticianId(bId);
            itemBeauticianShipList.add(itemBeauticianShip);
        }
        return itemBeauticianShipDao.addItemBeauticianShip(itemBeauticianShipList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer deleteItem(Long itemId) {
        List<ItemBeauticianShip> list = itemBeauticianShipDao.selectByItemId(itemId);
        List<Long> IdList = new ArrayList<>();
        for (ItemBeauticianShip itemBeauticianShip:list){
            IdList.add(itemBeauticianShip.getId());
        }
        itemBeauticianShipDao.deleteByList(IdList);
        return itemDao.deleteItem(itemId);
    }

    @Override
    public Integer updateItem(UpdateItemRequest updateItemRequest) {
        Item item = new Item();
        item.setUpdateTime(new Date());
        BeanUtils.copyProperties(updateItemRequest,item);
        return itemDao.updateItem(item);
    }

    @Override
    public SelectItemResponseList selectAllItem(SelectRequest selectRequest) {
        PageHelper.startPage(selectRequest.getPageNumber(),selectRequest.getPageSize());
        List<Item> itemList = itemDao.selectItem();
        Collections.shuffle(itemList);
        PageInfo<Item> pageInfo = new PageInfo<>(itemList);
        SelectItemResponseList selectItemResponseList = new SelectItemResponseList();
        List<SelectItemResponse> selectItemResponses = new ArrayList<>();
        for (Item item:pageInfo.getList()) {
            SelectItemResponse selectItemResponse = new SelectItemResponse();
            BeanUtils.copyProperties(item,selectItemResponse);
            selectItemResponse.setAppointPrice(item.getPrice()*0.2);
            selectItemResponse.setActrualPrice(item.getPrice()*0.8);
            String imgsUrl = item.getImgsUrl();
            if (!StringUtil.isNullOrEmpty(imgsUrl)){
                HashMap hashMap = JsonUtils.jsonToPoJo(imgsUrl, HashMap.class);
                List<ImgBo> imgBos = new ArrayList<>();
                Set<String> set = hashMap.keySet();
                for (String s:set) {
                    ImgBo imgBo = new ImgBo();
                    imgBo.setImgUUID(s);
                    imgBo.setImgUrl(hashMap.get(s).toString());
                    imgBos.add(imgBo);
                }
                selectItemResponse.setProductImgBoList(imgBos);
            }
            selectItemResponses.add(selectItemResponse);
        }
        selectItemResponseList.setItemList(selectItemResponses);
        selectItemResponseList.setTotal(pageInfo.getTotal());
        return selectItemResponseList;
    }

    @Override
    public SelectItemResponseList selectItemByTypes(SelectItemByTypeRequest selectItemByTypeRequest) {
        PageHelper.startPage(selectItemByTypeRequest.getPageNumber(),selectItemByTypeRequest.getPageSize());
        List<Item> itemList = itemDao.selectItemByType(selectItemByTypeRequest.getTypeId());
        Collections.shuffle(itemList);
        PageInfo<Item> pageInfo = new PageInfo<>(itemList);
        SelectItemResponseList selectItemResponseList = new SelectItemResponseList();
        List<SelectItemResponse> selectItemResponses = new ArrayList<>();
        for (Item item:pageInfo.getList()) {
            SelectItemResponse selectItemResponse = new SelectItemResponse();
            BeanUtils.copyProperties(item,selectItemResponse);
            selectItemResponse.setAppointPrice(item.getPrice()*0.2);
            selectItemResponse.setActrualPrice(item.getPrice()*0.8);
            String imgsUrl = item.getImgsUrl();
            if (!StringUtil.isNullOrEmpty(imgsUrl)){
                HashMap hashMap = JsonUtils.jsonToPoJo(imgsUrl, HashMap.class);
                List<ImgBo> imgBos = new ArrayList<>();
                Set<String> set = hashMap.keySet();
                for (String s:set) {
                    ImgBo imgBo = new ImgBo();
                    imgBo.setImgUUID(s);
                    imgBo.setImgUrl(hashMap.get(s).toString());
                    imgBos.add(imgBo);
                }
                selectItemResponse.setProductImgBoList(imgBos);
            }
            selectItemResponses.add(selectItemResponse);
        }
        selectItemResponseList.setItemList(selectItemResponses);
        selectItemResponseList.setTotal(pageInfo.getTotal());
        return selectItemResponseList;
    }
}
