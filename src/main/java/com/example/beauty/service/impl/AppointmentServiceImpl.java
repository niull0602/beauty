package com.example.beauty.service.impl;

import com.example.beauty.constant.BeautyConstant;
import com.example.beauty.dao.AppointmentDao;
import com.example.beauty.dao.ItemDao;
import com.example.beauty.dao.PayDao;
import com.example.beauty.pojo.Appointment;
import com.example.beauty.pojo.Item;
import com.example.beauty.pojo.Pay;
import com.example.beauty.request.AddAppointmentRequest;
import com.example.beauty.request.StatusAppointmentRequest;
import com.example.beauty.request.UpdateAppointment;
import com.example.beauty.request.UserAppointmentRequest;
import com.example.beauty.response.AdminSelectAppointmentResponse;
import com.example.beauty.response.AdminSelectAppointmentResponseList;
import com.example.beauty.response.UserAppointmentResponse;
import com.example.beauty.response.UserAppointmentResponseList;
import com.example.beauty.service.AppointmentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by NiuLilu on 2020-04-20 16:03.
 */
@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private AppointmentDao appointmentDao;
    @Autowired
    private PayDao payDao;
    @Autowired
    private ItemDao itemDao;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer addAppointment(AddAppointmentRequest addAppointmentRequest) {
        Appointment appointment = new Appointment();
        BeanUtils.copyProperties(addAppointmentRequest,appointment);
        Item item =itemDao.selectItemById(addAppointmentRequest.getItemId());
        item.setSaledNumber(item.getSaledNumber()+1);
        itemDao.updateItem(item);
        Pay pay = new Pay();
        pay.setPayStatus(BeautyConstant.PAY_SUCCESS);
        pay.setPayPrice(item.getPrice()*0.20);
        pay.setCreateTime(new Date());
        pay.setUpdateTime(new Date());
        pay.setUserId(addAppointmentRequest.getUserId());
        payDao.addPay(pay);
        appointment.setDepositPrice(item.getPrice()*0.20);
        appointment.setActualPrice(item.getPrice()*0.80);
        appointment.setCreateTime(new Date());
        appointment.setUpdateTime(new Date());
        appointment.setDepositPayId(pay.getId());
        return appointmentDao.add(appointment);
    }

    @Override
    public Integer update(UpdateAppointment updateAppointment) {
        Appointment appointment = new Appointment();
        BeanUtils.copyProperties(updateAppointment,appointment);
        appointment.setUpdateTime(new Date());
        return appointmentDao.update(appointment);
    }

    @Override
    public Integer deleteById(Long appointmentId) {
        return appointmentDao.delete(appointmentId);
    }

    @Override
    public UserAppointmentResponseList selectAppointmentByUserId(UserAppointmentRequest userAppointmentRequest) {
        UserAppointmentResponseList userAppointmentResponseList = new UserAppointmentResponseList();
        PageHelper.startPage(userAppointmentRequest.getPageNumber(),userAppointmentRequest.getPageSize());
        List<UserAppointmentResponse> appointmentResponseList= appointmentDao.selectAppointmentByUserId(userAppointmentRequest.getUserId());
        PageInfo<UserAppointmentResponse> pageInfo = new PageInfo<>(appointmentResponseList);
        userAppointmentResponseList.setList(pageInfo.getList());
        userAppointmentResponseList.setTotal(pageInfo.getTotal());
        return userAppointmentResponseList;
    }

    @Override
    public AdminSelectAppointmentResponseList selectAppointmentByStatus(StatusAppointmentRequest statusAppointmentRequest) {
        AdminSelectAppointmentResponseList adminSelectAppointmentResponseList = new AdminSelectAppointmentResponseList();
        PageHelper.startPage(statusAppointmentRequest.getPageNumber(),statusAppointmentRequest.getPageSize());
        List<AdminSelectAppointmentResponse> appointmentResponseList = appointmentDao.selectAppointmentByStatus(statusAppointmentRequest.getStatus());
        PageInfo<AdminSelectAppointmentResponse> pageInfo = new PageInfo<>(appointmentResponseList);
        adminSelectAppointmentResponseList.setList(pageInfo.getList());
        adminSelectAppointmentResponseList.setTotal(pageInfo.getTotal());
        return adminSelectAppointmentResponseList;
    }

    @Override
    public Integer payActrualAppoint(UpdateAppointment updateAppointment) {
        Pay pay = new Pay();
        pay.setUserId(updateAppointment.getUserId());
        pay.setUpdateTime(new Date());
        pay.setCreateTime(new Date());
        pay.setPayPrice(updateAppointment.getActualPrice());
        pay.setPayStatus(BeautyConstant.PAY_SUCCESS);
        payDao.addPay(pay);
        Appointment appointment = new Appointment();
        BeanUtils.copyProperties(updateAppointment,appointment);
        appointment.setUpdateTime(new Date());
        appointment.setActualPayId(pay.getId());
        return appointmentDao.update(appointment);
    }
}
