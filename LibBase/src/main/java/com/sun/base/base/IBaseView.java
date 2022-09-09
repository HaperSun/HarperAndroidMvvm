package com.sun.base.base;

/**
 * @author: Harper
 * @date: 2022/9/8
 * @note:
 */
public interface IBaseView {
    /**
     * 初始化界面传递参数
     */
    void initParam();
    /**
     * 初始化数据
     */
    void initData();

    /**
     * 初始化界面观察者的监听
     */
    void initViewObservable();
}
