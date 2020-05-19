package com.xiakai.weifuwu.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "t_product")
public class TProduct implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column
    private String name;
    @Column
    private Long price;
    @Column
    private Long salePrice;
    @Column
    private String salePoint;
    @Column
    private String image;
    @Column
    private Long stock;
    @Column
    private Boolean flag;
    @Column
    private Date createTime;
    @Column
    private Date updateTime;
    @Column
    private Long createUser;
    @Column
    private Long updateUser;
    @Column
    private Long typeId;
    @Column
    private String typeName;

}