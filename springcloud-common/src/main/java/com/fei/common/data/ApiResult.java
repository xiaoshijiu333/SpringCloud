package com.fei.common.data;

import com.fei.common.constant.StatusConstant;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author: xiaoshijiu
 * @Date: 2019/7/5
 * @Description: 返回前端模型结果
 */
@Getter
@Setter
public class ApiResult<T> {

    /**
     * 响应码，响应信息，响应数据
     */
    private int code;
    private String message;
    private T model;

    /**
     * 私有构造器，表明该类不允许直接实例化
     */
    private ApiResult(int code, String message, T model) {
        this.code = code;
        this.message = message;
        this.model = model;
    }

    private ApiResult() {
    }

    public static <T> ApiResult ok(T model) {
        return new ApiResult<>(StatusConstant.SUCCESS_CODE, StatusConstant.SUCCESS_MESSAGE, model);
    }

    public static ApiResult ok() {
        return new ApiResult<>(StatusConstant.SUCCESS_CODE, StatusConstant.SUCCESS_MESSAGE, null);
    }

    public static ApiResult fail() {
        return new ApiResult<>(StatusConstant.FAILURE_CODE, StatusConstant.FAILTURE_MESSAGE, null);
    }

    public static <T> ApiResult fail(T model) {
        return new ApiResult<>(StatusConstant.FAILURE_CODE, StatusConstant.FAILTURE_MESSAGE, model);
    }
}
