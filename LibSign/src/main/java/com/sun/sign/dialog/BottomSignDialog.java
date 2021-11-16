package com.sun.sign.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;


import com.sun.common.toast.ToastHelper;
import com.sun.sign.R;
import com.sun.sign.widget.SignatureInputView;

import java.io.File;

/**
 * @author: Harper
 * @date: 2021/10/29
 * @note: 底部签名弹窗
 */
public class BottomSignDialog extends Dialog implements View.OnClickListener {

    private final Context mContext;
    private String mConfirmStr;
    private OnDialogClickListener mOnDialogClickListener;
    private SignatureInputView mSignatureInputView;

    public BottomSignDialog(Context context) {
        super(context, R.style.dialog);
        mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_bottom_sign);
        initView();
    }

    private void initView() {
        setCanceledOnTouchOutside(true);
        //设置窗体位置以及动画
        Window window = getWindow();
        if (null != window) {
            window.setWindowAnimations(R.style.main_menu_animstyle);
            window.setGravity(Gravity.BOTTOM);
            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
        mSignatureInputView = findViewById(R.id.signature_pad);
        findViewById(R.id.tv_clear).setOnClickListener(v -> mSignatureInputView.clear());
        findViewById(R.id.tv_refuse).setOnClickListener(this);
        TextView confirmTextView = findViewById(R.id.tv_ok);
        confirmTextView.setText(mConfirmStr);
        confirmTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tv_ok) {
            if (!mSignatureInputView.isSignatureInputAvailable()) {
                ToastHelper.showCommonToast(mContext, "请签名！");
                return;
            }
            try {
                File file = mSignatureInputView.saveSignature();
                if (mOnDialogClickListener != null) {
                    mOnDialogClickListener.onClickConfirm(file);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                dismiss();
            }
        }
        dismiss();
    }

    public static class Builder {

        private final BottomSignDialog mDialog;

        public Builder(Context context) {
            mDialog = new BottomSignDialog(context);
        }

        public Builder setConfirmStr(String confirmStr) {
            mDialog.setConfirmStr(confirmStr);
            return this;
        }

        public Builder setOnDialogClickListener(OnDialogClickListener onDialogClickListener) {
            mDialog.setOnDialogClickListener(onDialogClickListener);
            return this;
        }

        public BottomSignDialog build() {
            return mDialog;
        }
    }

    private void setConfirmStr(String confirmStr) {
        mConfirmStr = confirmStr;
    }

    private void setOnDialogClickListener(OnDialogClickListener onDialogClickListener) {
        mOnDialogClickListener = onDialogClickListener;
    }

    public interface OnDialogClickListener {
        /**
         * 签名生成的文件
         *
         * @param file file
         */
        void onClickConfirm(File file);
    }
}
