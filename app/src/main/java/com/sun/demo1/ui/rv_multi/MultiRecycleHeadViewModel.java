package com.sun.demo1.ui.rv_multi;

import androidx.annotation.NonNull;

import com.sun.base.base.BaseViewModel;
import com.sun.base.base.MultiItemViewModel;
import com.sun.base.binding.command.BindingAction;
import com.sun.base.binding.command.BindingCommand;
import com.sun.base.util.ToastUtil;


/**
 * @author: Harper
 * @date: 2022/9/9
 * @note:
 */
public class MultiRecycleHeadViewModel extends MultiItemViewModel {

    public MultiRecycleHeadViewModel(@NonNull BaseViewModel viewModel) {
        super(viewModel);
    }

    //条目的点击事件
    public BindingCommand itemClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            ToastUtil.showShort("我是头布局");
        }
    });
}
