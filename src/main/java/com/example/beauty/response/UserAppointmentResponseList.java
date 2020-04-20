package com.example.beauty.response;

import lombok.Data;

import java.util.List;

/**
 * Created by NiuLilu on 2020-04-20 16:27.
 */
@Data
public class UserAppointmentResponseList {
    private List<UserAppointmentResponse> list;
    private Long total;
}
