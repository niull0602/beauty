package com.example.beauty.service;

import com.example.beauty.request.AddAdRequest;
import com.example.beauty.request.SelectRequest;
import com.example.beauty.request.UpdateAdRequest;
import com.example.beauty.response.SelectAdResponseList;

/**
 * Created by NiuLilu on 2020-04-17 9:13.
 */
public interface AdService {
    Integer addAd(AddAdRequest addAdRequest);

    SelectAdResponseList selectAllAd(SelectRequest selectRequest);

    Integer updateAd(UpdateAdRequest updateAdRequest);

    Integer deleteAdById(Integer id);

    SelectAdResponseList selectAd(SelectRequest selectRequest);
}
