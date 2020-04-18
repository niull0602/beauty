package com.example.beauty.service;

import com.example.beauty.request.AddBeauticianRequest;
import com.example.beauty.request.SelectRequest;
import com.example.beauty.request.UpdateBeauticianRequest;
import com.example.beauty.response.SelectBeauticianResponseList;

/**
 * Created by NiuLilu on 2020-04-17 9:54.
 */
public interface BeauticianService {
    Integer addBeautician(AddBeauticianRequest addBeauticianRequest);

    Integer deleteBeautician(Long id);

    Integer updateBeautician(UpdateBeauticianRequest updateBeauticianRequest);

    SelectBeauticianResponseList selectAll(SelectRequest selectRequest);

}
