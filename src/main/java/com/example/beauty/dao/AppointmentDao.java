package com.example.beauty.dao;

import com.example.beauty.mapper.AppointmentMapper;
import com.example.beauty.pojo.Appointment;
import com.example.beauty.response.AdminSelectAppointmentResponse;
import com.example.beauty.response.UserAppointmentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by NiuLilu on 2020-04-20 15:54.
 */
@Repository
public class AppointmentDao {
    @Autowired
    private AppointmentMapper appointmentMapper;

    public Integer add(Appointment appointment) {
        return appointmentMapper.insert(appointment);
    }

    public Integer delete(Long id){
        return appointmentMapper.deleteByPrimaryKey(id);
    }

    public Integer update(Appointment appointment) {
        return appointmentMapper.updateByPrimaryKeySelective(appointment);
    }

    public List<UserAppointmentResponse> selectAppointmentByUserId(Long userId) {
        return appointmentMapper.selectAppointmentByUserId(userId);
    }

    public List<AdminSelectAppointmentResponse> selectAppointmentByStatus(Short status) {
        return appointmentMapper.selectAppointmentByStatus(status);
    }
}
