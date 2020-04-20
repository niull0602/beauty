package com.example.beauty.pojo;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_appointment")
@Data
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "beautician_id")
    private Long beauticianId;

    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "end_time")
    private Date endTime;

    /**
     * 时长（分钟）
     */
    private Integer duration;

    /**
     * 定金
     */
    @Column(name = "deposit_price")
    private Double depositPrice;

    @Column(name = "actual_price")
    private Double actualPrice;

    /**
     * 预约状态
     */
    private Short status;

    /**
     * 客户满意度
     */
    @Column(name = "customer_satisfaction")
    private Short customerSatisfaction;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "deposit_pay_id")
    private Long depositPayId;

    @Column(name = "actual_pay_id")
    private Long actualPayId;

    }