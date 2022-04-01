package com.feng.ssmp.utils;

import lombok.Data;

/**
 * 返回结果模型类
 * 用于前后端数据格式的统一，也称为前后端数据格式协议
 */
@Data
public class R {

    private Boolean flag;//查询是否成功
    private Object data;//返回的数据
    private String mess;

    public R() {
    }

    public R(Object data) {
        this.flag = true;
        this.data = data;
    }

    public R(Boolean flag) {
        this.flag = flag;
    }

    public R(Boolean flag, String mess) {
        this.flag = flag;
        this.mess = mess;
    }
}
