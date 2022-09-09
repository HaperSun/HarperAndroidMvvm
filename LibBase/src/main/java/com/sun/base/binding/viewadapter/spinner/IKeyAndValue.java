package com.sun.base.binding.viewadapter.spinner;

/**
 * @author: Harper
 * @date: 2022/9/8
 * @note: 下拉Spinner控件的键值对, 实现该接口,返回key,value值, 在xml绑定List<IKeyAndValue>
 */
public interface IKeyAndValue {
    String getKey();

    String getValue();
}
