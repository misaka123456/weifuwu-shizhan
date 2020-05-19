package com.xiakai.weifuwu.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Table(name = "t_product_desc")
public class TProductDesc implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column
    private Long productId;
    @Column
    private String productDesc;


}