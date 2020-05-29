package com.xiakai.weifuwu.api.search;

import com.xiakai.common.pojo.PageInfoBean;
import com.xiakai.common.pojo.ResultBean;
import com.xiakai.weifuwu.entity.TProduct;

import java.util.List;

/**
 * @author xiakai
 * @create 2020-05-25 09:18
 */
public interface ISearchProductService {

    ResultBean initAllData();

    PageInfoBean<TProduct> searchByKeyWord(String keyWord, Integer pageIndex, Integer pageSize);

    void add(TProduct product);

    void deleteById(Long id);


}
