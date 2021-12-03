package com.sun.demo.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;

import com.sun.base.ui.activity.BaseMvpActivity;
import com.sun.base.util.LogUtil;
import com.sun.demo.R;
import com.sun.demo.databinding.ActivitySignBinding;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        ActivitySignBinding binding = (ActivitySignBinding) mViewDataBinding;
        binding.aa.setEchoSign();
    }

    @Override
    public void initData() {
        long a = string2Millis("2021-11-30 11:30");
        long b = string2Millis("2021-11-30 11:40");
        LogUtil.e("hh", a + "-----" + b);
    }

    /**
     * 将字符串转为时间戳
     *
     * @param dateString
     * @return
     */
    public static long string2Millis(String dateString) {
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = new Date();
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime();
    }
}