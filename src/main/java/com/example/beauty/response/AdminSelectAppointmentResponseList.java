package com.example.beauty.response;

import lombok.Data;

import java.util.List;

/**
 * Created by NiuLilu on 2020-04-20 17:09.
 */
@Data
public class AdminSelectAppointmentResponseList {
    private List<AdminSelectAppointmentResponse> list;
    private Long total;
}
