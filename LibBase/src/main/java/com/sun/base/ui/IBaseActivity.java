package com.sun.base.ui;

import android.os.Bundle;

/**
 * @author: Harper
 * @date: 2021/11/12
 * @note:
 */

public interface IBaseActivity {

    /**
     * 设置布局前走的方法
     * @param savedInstanceState Bundle
     */
    void beforeSetContentView(Bundle savedInstanceState);

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
