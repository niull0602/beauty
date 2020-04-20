package com.example.beauty.request;

import lombok.Data;

/**
 * Created by NiuLilu on 2020-04-20 16:28.
 */
@Data
public class UserAppointmentRequest {
    private Long userId;

    private Integer pageNumber=1;

    private Integer pageSize=10;
}
