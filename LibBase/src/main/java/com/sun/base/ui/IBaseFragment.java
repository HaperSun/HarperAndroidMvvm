package com.sun.base.ui;

/**
 * @author: Harper
 * @date: 2021/11/12
 * @note:
 */
public interface IBaseFragment {
    /**
     * 获取布局id
     *
     * @return id
     */
    int layoutId();

    /**
     * 初始化view
     */
    void initView();

    /**
     * 初始化数据
     */
    void initData();
}
