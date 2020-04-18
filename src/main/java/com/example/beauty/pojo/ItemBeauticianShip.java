package com.example.beauty.pojo;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Table(name = "t_item_beautician_ship")
@Entity
public class ItemBeauticianShip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "beautician_id")
    private Long beauticianId;

}