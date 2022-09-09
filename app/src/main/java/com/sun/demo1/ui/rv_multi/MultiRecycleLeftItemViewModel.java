package com.sun.demo1.ui.rv_multi;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;

import com.sun.base.base.MultiItemViewModel;
import com.sun.base.binding.command.BindingAction;
import com.sun.base.binding.command.BindingCommand;
import com.sun.base.util.ToastUtil;


/**
 * @author: Harper
 * @date: 2022/9/9
 * @note:
 */
public class MultiRecycleLeftItemViewModel extends MultiItemViewModel<MultiRecycleViewModel> {
    public ObservableField<String> text = new ObservableField<>("");

    public MultiRecycleLeftItemViewModel(@NonNull MultiRecycleViewModel viewModel, String text) {
        super(viewModel);
        this.text.set(text);
    }

    //条目的点击事件
    public BindingCommand itemClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            //拿到position
            int position = viewModel.observableList.indexOf(MultiRecycleLeftItemViewModel.this);
            ToastUtil.showShort("position：" + position);
        }
    });
}
