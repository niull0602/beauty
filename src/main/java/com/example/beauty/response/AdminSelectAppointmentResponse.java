package com.example.beauty.response;

import lombok.Data;

import java.util.Date;

/**
 * Created by NiuLilu on 2020-04-20 17:13.
 */
@Data
public class AdminSelectAppointmentResponse {
    private Long id;

    private Long userId;

    private Long itemId;

    private String itemName;

    private Long beauticianId;

    private Date startTime;

    private Date endTime;

    private Integer duration;

    private Short status;

    /**
     * 客户满意度
     */
    private Short customerSatisfaction;

    private Date createTime;

}
