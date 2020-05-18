package com.xiakai.service.impl;

import com.xiakai.service.IUserService;

/**
 * @author xiakai
 * @create 2020-05-18 14:46
 */
public class UserServiceImpl implements IUserService {


    @Override
    public String hello() {
        return "hello, dubbo!  04";
    }
}
