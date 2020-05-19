package com.xiakai.weifuwu.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Table(name = "t_product_type")
public class TProductType implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column
    private Long pid;
    @Column
    private String name;


}