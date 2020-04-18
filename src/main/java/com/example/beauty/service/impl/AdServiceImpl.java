package com.example.beauty.service.impl;

import com.example.beauty.dao.AdDao;
import com.example.beauty.pojo.Ad;
import com.example.beauty.request.AddAdRequest;
import com.example.beauty.request.SelectRequest;
import com.example.beauty.request.UpdateAdRequest;
import com.example.beauty.response.SelectAdResponseList;
import com.example.beauty.service.AdService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by NiuLilu on 2020-04-17 9:13.
 */
@Service
public class AdServiceImpl implements AdService {
    @Autowired
    private AdDao adDao;


    @Override
    public Integer addAd(AddAdRequest addAdRequest) {
        Ad ad = new Ad();
        BeanUtils.copyProperties(addAdRequest,ad);
        ad.setCreateTime(new Date());
        ad.setUpdateTime(new Date());
        return adDao.addAd(ad);
    }

    @Override
    public SelectAdResponseList selectAllAd(SelectRequest request) {
        PageHelper.startPage(request.getPageNumber(),request.getPageSize());
        List<Ad> adList = adDao.selectAll();
        PageInfo<Ad> adPageInfo = new PageInfo<>(adList);
        List<Ad> list = adPageInfo.getList();
        SelectAdResponseList selectAdResponseList = new SelectAdResponseList();
        selectAdResponseList.setList(adList);
        selectAdResponseList.setTotal(adPageInfo.getTotal());
        return selectAdResponseList;
    }

    @Override
    public Integer updateAd(UpdateAdRequest updateAdRequest) {
        Ad ad = new Ad();
        BeanUtils.copyProperties(updateAdRequest,ad);
        ad.setUpdateTime(new Date());
        return adDao.updateAd(ad);
    }

    @Override
    public Integer deleteAdById(Integer id) {
        return adDao.deleteAdById(id);
    }

    @Override
    public SelectAdResponseList selectAd(SelectRequest request) {
        PageHelper.startPage(request.getPageNumber(),request.getPageSize());
        List<Ad> adList = adDao.selectAd();
        PageInfo<Ad> adPageInfo = new PageInfo<>(adList);
        List<Ad> list = adPageInfo.getList();
        SelectAdResponseList selectAdResponseList = new SelectAdResponseList();
        selectAdResponseList.setList(adList);
        selectAdResponseList.setTotal(adPageInfo.getTotal());
        return selectAdResponseList;
    }
}
