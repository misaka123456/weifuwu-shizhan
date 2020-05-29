package com.xiakai.weifuwu.api;

import com.xiakai.common.pojo.ResultBean;
import com.xiakai.weifuwu.entity.TProduct;

import java.util.List;

/**
 * @author xiakai
 * @create 2020-05-26 16:14
 */
public interface IProductItemService {

    ResultBean createHtmlById(Long productId);

    ResultBean batchCreateHtml(List<Long> idList);

    public ResultBean updateHtml(TProduct product);
}
