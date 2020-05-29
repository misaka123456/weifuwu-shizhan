package com.xiakai.weifuwu.api.product.service;

import com.xiakai.common.base.BaseServiceImpl;
import com.xiakai.common.base.IBaseMapper;
import com.xiakai.weifuwu.entity.TProductDesc;
import com.xiakai.weifuwu.api.product.IProductDescService;

/**
 * @author xiakai
 * @create 2020-05-24 21:58
 */
public class ProductDescService extends BaseServiceImpl<TProductDesc> implements IProductDescService {



    @Override
    public IBaseMapper<TProductDesc> getBaseMapper() {
        return null;
    }
}
