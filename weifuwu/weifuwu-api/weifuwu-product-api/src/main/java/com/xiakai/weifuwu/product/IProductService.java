package com.xiakai.weifuwu.product;

import com.github.pagehelper.PageInfo;
import com.xiakai.common.base.IBaseService;
import com.xiakai.weifuwu.entity.TProduct;
import com.xiakai.weifuwu.vo.ProductVO;

/**
 * @author xiakai
 * @create 2020-05-19 19:02
 */
public interface IProductService extends IBaseService<TProduct> {


    PageInfo<TProduct> page(Integer index, Integer size);

    Long add(ProductVO productVO);
}
