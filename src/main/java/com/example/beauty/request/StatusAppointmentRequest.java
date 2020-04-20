package com.example.beauty.request;

import lombok.Data;

/**
 * Created by NiuLilu on 2020-04-20 17:08.
 */
@Data
public class StatusAppointmentRequest {
    private Short status=0;
    private Integer pageNumber;
    private Integer pageSize;
}
