package com.xiakai.common.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xiakai
 * @create 2020-05-23 22:21
 */
@Data
public class ResultBean implements Serializable {


    private Integer statusCode;

    private String data;

    private String msg;

    public static ResultBean SUCCESS(String data) {
        ResultBean resultBean = new ResultBean();
        resultBean.setData(data);
        resultBean.setStatusCode(200);
        return resultBean;
    }

    public static ResultBean ERROR(String msg, int code) {
        ResultBean resultBean = new ResultBean();
        resultBean.setMsg(msg);
        resultBean.setStatusCode(code);
        return resultBean;
    }

}
