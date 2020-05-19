package com.xiakai.common.base;

import java.util.List;

/**
 * @author xiakai
 * @create 2020-05-18 21:44
 */
public abstract class BaseServiceImpl<T> implements IBaseService<T> {

    public abstract IBaseMapper<T> getBaseMapper();

    public int deleteByPrimaryKey(Long key) {
        return getBaseMapper().deleteByPrimaryKey(key);
    }

    public int insert(T t) {
        return getBaseMapper().insert(t);
    }

    public int insertSelective(T t) {
        return getBaseMapper().insertSelective(t);
    }

    public T selectByPrimaryKey(Long key) {
        return getBaseMapper().selectByPrimaryKey(key);
    }

    public int updateByPrimaryKey(T t) {
        return getBaseMapper().updateByPrimaryKey(t);
    }

    public int updateByPrimaryKeySelective(T t) {
        return getBaseMapper().updateByPrimaryKeySelective(t);
    }

    public List<T> list() {
        return getBaseMapper().list();
    }

}
