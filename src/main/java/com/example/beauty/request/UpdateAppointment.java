package com.example.beauty.request;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

/**
 * Created by NiuLilu on 2020-04-20 16:12.
 */
@Data
public class UpdateAppointment {
    private Long id;

    private Long userId;

    private Long itemId;

    private Long beauticianId;

    private Date startTime;

    private Date endTime;

    /**
     * 时长（分钟）
     */
    private Integer duration;

    /**
     * 定金
     */

    private Double depositPrice;


    private Double actualPrice;

    /**
     * 预约状态
     */
    private Short status;

    /**
     * 客户满意度
     */

    private Short customerSatisfaction;

    private Long depositPayId;

    private Long actualPayId;
}
