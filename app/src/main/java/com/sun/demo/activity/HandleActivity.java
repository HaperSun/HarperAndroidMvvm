package com.sun.demo.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

import com.sun.base.ui.activity.BaseMvpActivity;
import com.sun.common.UiHandler;
import com.sun.demo.R;
import com.sun.demo.databinding.ActivityHandleBinding;

/**
 * @author: Harper
 * @date: 2021/11/11
 * @note: handle的使用
 */
public class HandleActivity extends BaseMvpActivity {

    private final MyHandler mHandler = new MyHandler(this);
    @SuppressLint("StaticFieldLeak")
    private static TextView mTextView;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, HandleActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void initView() {
        ViewDataBinding viewDataBinding = getDataBinding();
        if (viewDataBinding != null) {
            ActivityHandleBinding binding = (ActivityHandleBinding) viewDataBinding;
            mTextView = binding.handleText;
        }
    }

    @Override
    public void initData() {
        mHandler.post(mRunnable);
    }

    private final Runnable mRunnable = () -> {
        mHandler.sendEmptyMessageDelayed(0, 3000);
    };

    @Override
    public int layoutId() {
        return R.layout.activity_handle;
    }

    private static class MyHandler extends UiHandler<HandleActivity> {

        private MyHandler(HandleActivity activity) {
            super(activity);
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            HandleActivity activity = getRef();
            if (activity != null) {
                if (activity.isFinishing()) {
                    return;
                }
                int msgId = msg.what;
                if (msgId == 0) {
                    //处理消息
                    mTextView.setText("我是消息！");
                }
            }
        }
    }
}