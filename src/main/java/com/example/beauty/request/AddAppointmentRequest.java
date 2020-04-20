package com.example.beauty.request;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

/**
 * Created by NiuLilu on 2020-04-20 16:06.
 */
@Data
public class AddAppointmentRequest {
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
     * 预约状态
     */
    private Short status;

    private Long depositPayId;

}
