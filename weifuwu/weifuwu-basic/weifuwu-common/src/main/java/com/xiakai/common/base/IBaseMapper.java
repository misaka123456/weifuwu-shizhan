package com.xiakai.common.base;


import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

public interface IBaseMapper<T> extends Mapper<T>, MySqlMapper<T> {

    List<T> list();
}
