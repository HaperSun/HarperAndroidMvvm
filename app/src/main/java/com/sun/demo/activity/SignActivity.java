package com.sun.demo.activity;

import android.content.Context;
import android.content.Intent;

import androidx.databinding.ViewDataBinding;

import com.sun.base.ui.activity.BaseMvpActivity;
import com.sun.demo.R;
import com.sun.demo.databinding.ActivitySignBinding;

/**
 * @author: Harper
 * @date: 2021/11/10
 * @note: 模拟签名
 */
public class SignActivity extends BaseMvpActivity {

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, SignActivity.class);
        context.startActivity(intent);
    }

    @Override
    public int layoutId() {
        return R.layout.activity_sign;
    }

    @Override
    public void initView() {
        ViewDataBinding viewDataBinding = getDataBinding();
        if (viewDataBinding != null){
            ActivitySignBinding binding = (ActivitySignBinding) viewDataBinding;
            binding.aa.setEchoSign();
        }
    }

    @Override
    public void initData() {
//        BuildConfig.DEBUG
    }
}