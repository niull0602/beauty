package com.example.beauty.service.impl;

import com.example.beauty.dao.BeauticianDao;
import com.example.beauty.pojo.Beautician;
import com.example.beauty.request.AddBeauticianRequest;
import com.example.beauty.request.SelectRequest;
import com.example.beauty.request.UpdateBeauticianRequest;
import com.example.beauty.response.SelectBeauticianResponseList;
import com.example.beauty.service.BeauticianService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by NiuLilu on 2020-04-17 9:54.
 */
@Service
public class BeauticianServiceImpl implements BeauticianService {
    @Autowired
    private BeauticianDao beauticianDao;

    @Override
    public Integer addBeautician(AddBeauticianRequest addBeauticianRequest) {
        Beautician beautician = new Beautician();
        BeanUtils.copyProperties(addBeauticianRequest,beautician);
        beautician.setCreateTime(new Date());
        beautician.setUpdateTime(new Date());
        return beauticianDao.add(beautician);
    }

    @Override
    public Integer deleteBeautician(Long id) {
        return beauticianDao.deleteById(id);
    }

    @Override
    public Integer updateBeautician(UpdateBeauticianRequest updateBeauticianRequest) {
        Beautician beautician = new Beautician();
        BeanUtils.copyProperties(updateBeauticianRequest,beautician);
        beautician.setUpdateTime(new Date());
        return beauticianDao.update(beautician);
    }

    @Override
    public SelectBeauticianResponseList selectAll(SelectRequest selectRequest) {
        PageHelper.startPage(selectRequest.getPageNumber(),selectRequest.getPageSize());
        List<Beautician> beauticianList = beauticianDao.selectAll();
        PageInfo<Beautician> pageInfo = new PageInfo<>(beauticianList);
        List<Beautician> list = pageInfo.getList();
        SelectBeauticianResponseList selectBeauticianResponseList = new SelectBeauticianResponseList();
        selectBeauticianResponseList.setList(list);
        selectBeauticianResponseList.setTotal(pageInfo.getTotal());
        return selectBeauticianResponseList;
    }
}
