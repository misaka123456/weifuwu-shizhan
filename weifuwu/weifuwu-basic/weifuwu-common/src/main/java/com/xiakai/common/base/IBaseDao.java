package com.xiakai.common.base;

public interface IBaseDao<T> {

    int deleteByPrimaryKey(Long key);

    int insert(T t);

    int insertSelective(T t);

    T selectByPrimaryKey(Long key);

    int updateByPrimaryKey(T t);

    int updateByPrimaryKeySelective(T t);

}
