package com.example.beauty.service;

import com.example.beauty.request.AddAppointmentRequest;
import com.example.beauty.request.StatusAppointmentRequest;
import com.example.beauty.request.UpdateAppointment;
import com.example.beauty.request.UserAppointmentRequest;
import com.example.beauty.response.AdminSelectAppointmentResponseList;
import com.example.beauty.response.UserAppointmentResponseList;

/**
 * Created by NiuLilu on 2020-04-20 16:03.
 */
public interface AppointmentService {
    Integer addAppointment(AddAppointmentRequest addAppointmentRequest);

    Integer update(UpdateAppointment updateAppointment);

    Integer deleteById(Long appointmentId);

    UserAppointmentResponseList selectAppointmentByUserId(UserAppointmentRequest userAppointmentRequest);

    AdminSelectAppointmentResponseList selectAppointmentByStatus(StatusAppointmentRequest statusAppointmentRequest);

    Integer payActrualAppoint(UpdateAppointment updateAppointment);
}
