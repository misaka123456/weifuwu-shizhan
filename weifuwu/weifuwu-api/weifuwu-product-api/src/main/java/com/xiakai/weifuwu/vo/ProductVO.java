package com.xiakai.weifuwu.vo;

import com.xiakai.weifuwu.entity.TProduct;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xiakai
 * @create 2020-05-19 22:22
 */
@Data
public class ProductVO implements Serializable {

    private TProduct product;
    private String productDesc;

}
