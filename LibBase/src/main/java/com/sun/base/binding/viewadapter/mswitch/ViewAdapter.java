package com.sun.base.binding.viewadapter.mswitch;

import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.databinding.BindingAdapter;

import com.sun.base.binding.command.BindingCommand;


/**
 * @author: Harper
 * @date: 2022/9/8
 * @note:
 */
public class ViewAdapter {
    /**
     * 设置开关状态
     *
     * @param mSwitch Switch控件
     */
    @BindingAdapter("switchState")
    public static void setSwitchState(Switch mSwitch, boolean isChecked) {
        mSwitch.setChecked(isChecked);
    }

    /**
     * Switch的状态改变监听
     *
     * @param mSwitch        Switch控件
     * @param changeListener 事件绑定命令
     */
    @BindingAdapter("onCheckedChangeCommand")
    public static void onCheckedChangeCommand(final Switch mSwitch, final BindingCommand<Boolean> changeListener) {
        if (changeListener != null) {
            mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    changeListener.execute(isChecked);
                }
            });
        }
    }
}
