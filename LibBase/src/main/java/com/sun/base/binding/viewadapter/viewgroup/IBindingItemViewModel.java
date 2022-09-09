package com.sun.base.binding.viewadapter.viewgroup;

import androidx.databinding.ViewDataBinding;

/**
 * @author: Harper
 * @date: 2022/9/8
 * @note:
 */
public interface IBindingItemViewModel<V extends ViewDataBinding> {
    void injecDataBinding(V binding);
}
