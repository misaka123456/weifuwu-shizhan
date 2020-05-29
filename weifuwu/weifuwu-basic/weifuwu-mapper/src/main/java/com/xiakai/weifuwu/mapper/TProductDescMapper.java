package com.xiakai.weifuwu.mapper;

import com.xiakai.common.base.IBaseMapper;
import com.xiakai.weifuwu.entity.TProductDesc;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;


@Component
@Mapper
public interface TProductDescMapper extends IBaseMapper<TProductDesc> {

    @Delete("delete from t_product_desc where product_id = #{id}")
    Integer deleteByProductId(Long id);
}