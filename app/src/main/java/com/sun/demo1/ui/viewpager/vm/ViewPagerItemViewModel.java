package com.sun.demo1.ui.viewpager.vm;

import androidx.annotation.NonNull;

import com.sun.base.base.ItemViewModel;
import com.sun.base.binding.command.BindingAction;
import com.sun.base.binding.command.BindingCommand;


/**
 * @author: Harper
 * @date: 2022/9/9
 * @note: 所有例子仅做参考,千万不要把它当成一种标准,毕竟主打的不是例子,业务场景繁多,理解如何使用才最重要。
 */
public class ViewPagerItemViewModel extends ItemViewModel<ViewPagerViewModel> {
    public String text;

    public ViewPagerItemViewModel(@NonNull ViewPagerViewModel viewModel, String text) {
        super(viewModel);
        this.text = text;
    }

    public BindingCommand onItemClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            //点击之后将逻辑转到activity中处理
            viewModel.itemClickEvent.setValue(text);
        }
    });
}
