package com.xiakai.weifuwuproductservice.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiakai.common.base.BaseServiceImpl;
import com.xiakai.common.base.IBaseMapper;
import com.xiakai.weifuwu.entity.TProduct;
import com.xiakai.weifuwu.mapper.TProductMapper;
import com.xiakai.weifuwu.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xiakai
 * @create 2020-05-19 19:03
 */
@Service
public class ProductService extends BaseServiceImpl<TProduct> implements IProductService {

    @Autowired
    private TProductMapper tProductMapper;

    @Override
    public IBaseMapper<TProduct> getBaseMapper() {
        return tProductMapper;
    }
}
