package com.example.beauty.response;

import com.example.beauty.pojo.Beautician;
import com.example.beauty.pojo.Item;
import lombok.Data;

import java.util.Date;

/**
 * Created by NiuLilu on 2020-04-20 16:29.
 */
@Data
public class UserAppointmentResponse {
    private Long id;

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

    private Item item;

    private Beautician beautician;
}
