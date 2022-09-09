package com.sun.base.base;


import androidx.annotation.NonNull;

/**
 * @author: Harper
 * @date: 2022/9/8
 * @note: RecycleView多布局ItemViewModel是封装
 */
public class MultiItemViewModel<VM extends BaseViewModel> extends ItemViewModel<VM> {

    protected Object multiType;

    public Object getItemType() {
        return multiType;
    }

    public void multiItemType(@NonNull Object multiType) {
        this.multiType = multiType;
    }

    public MultiItemViewModel(@NonNull VM viewModel) {
        super(viewModel);
    }
}
