package com.sun.base.base;


import androidx.annotation.NonNull;

/**
 * @author: Harper
 * @date: 2022/9/8
 * @note:
 */
public class ItemViewModel<VM extends BaseViewModel> {

    protected VM viewModel;

    public ItemViewModel(@NonNull VM viewModel) {
        this.viewModel = viewModel;
    }
}
