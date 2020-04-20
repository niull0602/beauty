package com.example.beauty.controller;

import com.example.beauty.common.SzpJsonResult;
import com.example.beauty.request.AddAppointmentRequest;
import com.example.beauty.request.StatusAppointmentRequest;
import com.example.beauty.request.UpdateAppointment;
import com.example.beauty.request.UserAppointmentRequest;
import com.example.beauty.response.AdminSelectAppointmentResponseList;
import com.example.beauty.response.UserAppointmentResponseList;
import com.example.beauty.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Created by NiuLilu on 2020-04-20 15:54.
 */
@RestController
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @PostMapping(value = "add/appointment")
    public SzpJsonResult<Integer> addAppointment(@RequestBody AddAppointmentRequest addAppointmentRequest){
        return SzpJsonResult.ok(appointmentService.addAppointment(addAppointmentRequest));
    }

    @PostMapping(value = "pay/actual/appointment")
    public SzpJsonResult<Integer> payActualAppointment(@RequestBody UpdateAppointment updateAppointment){
        return SzpJsonResult.ok(appointmentService.payActrualAppoint(updateAppointment));
    }

    @PutMapping(value = "update/appointment")
    public SzpJsonResult<Integer> updateAppointment(@RequestBody UpdateAppointment updateAppointment){
        return SzpJsonResult.ok(appointmentService.update(updateAppointment));
    }

    @DeleteMapping(value = "delete/appointment/{appointmentId}")
    public SzpJsonResult<Integer> deleteAppointment(@PathVariable(value = "appointmentId")Long appointmentId){
        return SzpJsonResult.ok(appointmentService.deleteById(appointmentId));
    }

    @PostMapping(value = "select/appointment/userId")
    public SzpJsonResult<UserAppointmentResponseList> selectAppointmentByUserId(@RequestBody UserAppointmentRequest userAppointmentRequest){
        return SzpJsonResult.ok(appointmentService.selectAppointmentByUserId(userAppointmentRequest));
    }

    @PostMapping(value = "select/appointment/status")
    public SzpJsonResult<AdminSelectAppointmentResponseList> selectAppointmentByStatus(@RequestBody StatusAppointmentRequest statusAppointmentRequest){
        return SzpJsonResult.ok(appointmentService.selectAppointmentByStatus(statusAppointmentRequest));
    }
}
