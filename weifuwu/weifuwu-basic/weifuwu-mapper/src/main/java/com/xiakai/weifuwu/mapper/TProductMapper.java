package com.xiakai.weifuwu.mapper;

import com.xiakai.common.base.IBaseMapper;
import com.xiakai.weifuwu.entity.TProduct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface TProductMapper extends IBaseMapper<TProduct> {

    @Override
    @Select("select * from t_product where flag = 1")
    List<TProduct> list();
}