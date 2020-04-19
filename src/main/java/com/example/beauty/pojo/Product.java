package com.example.beauty.pojo;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "t_product")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;
    @Column(name = "product_name")
    private String productName;

    /**
     * 进价
     */
    private Double price;

    /**
     * 售价
     */
    @Column(name = "sale_price")
    private Double salePrice;

    @Column(name = "product_img")
    private String productImg;

    @Column(name = "product_imgs")
    private String productImgs;

    @Column(name = "product_desc")
    private String productDesc;

    /**
     * 库存量
     */
    @Column(name = "exist_number")
    private Integer existNumber;

    /**
     * 销售量
     */
    @Column(name = "sale_number")
    private Integer saleNumber;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "type_id")
    private Long typeId;

    }