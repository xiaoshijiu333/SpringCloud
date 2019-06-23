package com.fei.common.constant;

/**
 * @Author: xiaoshijiu
 * @Date: 2019/6/23
 * @Description: 时间常量
 */
public class DateConstant {
    public static final String DATE_FORMAT1 ="yyyy-MM-dd HH:mm";
    public static final String DATE_FORMAT2 ="yyyy-MM-dd HH:mm:ss";
    public static final String TIME_ZONE ="GMT+8";

    /**
     * 工具类不可被实例化，所以最好添加一个私有的构造器，指明不可被实例化
     */
    private DateConstant() {
    }
}
