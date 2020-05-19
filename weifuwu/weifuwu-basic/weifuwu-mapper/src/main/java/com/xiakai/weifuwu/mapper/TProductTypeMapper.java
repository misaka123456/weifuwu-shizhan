package com.xiakai.weifuwu.mapper;

import com.xiakai.common.base.IBaseMapper;
import com.xiakai.weifuwu.entity.TProductType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface TProductTypeMapper extends IBaseMapper<TProductType> {

    @Select("select * from t_product_type")
    List<TProductType> list();

}