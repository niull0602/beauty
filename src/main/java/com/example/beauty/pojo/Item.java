package com.example.beauty.pojo;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "t_item")
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @Column(name = "item_name")
    private String itemName;

    private Double price;

    @Column(name = "item_img")
    private String itemImg;

    @Column(name = "imgs_url")
    private String imgsUrl;

    /**
     * 主要功效
     */
    @Column(name = "main_function")
    private String mainFunction;

    /**
     * 针对人群
     */
    @Column(name = "target_crowd")
    private String targetCrowd;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 已预约次数
     */
    @Column(name = "type_id")
    private Long typeId;

    /**
     * 已预约次数
     */
    @Column(name = "saled_number")
    private Integer saledNumber;

}