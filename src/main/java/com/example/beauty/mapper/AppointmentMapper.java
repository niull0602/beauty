package com.example.beauty.mapper;

import com.example.beauty.pojo.Appointment;
import com.example.beauty.response.AdminSelectAppointmentResponse;
import com.example.beauty.response.UserAppointmentResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AppointmentMapper extends CommonMapper<Appointment> {
    List<UserAppointmentResponse> selectAppointmentByUserId(@Param(value = "userId")Long userId);

    List<AdminSelectAppointmentResponse> selectAppointmentByStatus(@Param(value = "status")Short status);
}