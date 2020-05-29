package com.xiakai.weifuwu.api.product.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiakai.common.base.BaseServiceImpl;
import com.xiakai.common.base.IBaseMapper;
import com.xiakai.weifuwu.entity.TProductType;
import com.xiakai.weifuwu.mapper.TProductTypeMapper;
import com.xiakai.weifuwu.api.product.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author xiakai
 * @create 2020-05-19 12:59
 */
@Service
public class ProductTypeService extends BaseServiceImpl<TProductType> implements IProductTypeService {

    // 注入dao层
    @Autowired
    private TProductTypeMapper productTypeMapper;

    @Override
    public IBaseMapper<TProductType> getBaseMapper() {
        return productTypeMapper;
    }


}
