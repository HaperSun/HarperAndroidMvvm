package com.sun.demo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.sun.demo.R;
import com.sun.sign.dialog.BottomSignDialog;


/**
 * @author Harper
 * @date 2021/11/5
 * note: 公共签字模块，可修改签字
 */
public class CommonSignWidget extends LinearLayout implements View.OnClickListener {

    private final Context mContext;
    private TextView mSignTextView;
    private boolean mIsChangeSign;
    private OnCommonSignWidgetListener mOnCommonSignWidgetListener;

    public CommonSignWidget(Context context) {
        this(context, null);
    }

    public CommonSignWidget(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CommonSignWidget(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        LayoutInflater.from(context).inflate(R.layout.widget_common_sign, this);
        setOrientation(VERTICAL);
        initWidget();
    }

    private void initWidget() {
        mSignTextView = findViewById(R.id.common_sign_txt);
        mSignTextView.setOnClickListener(this);
        mSignTextView.setText("点击签字");
    }

    /**
     * 回显签名
     */
    public void setEchoSign() {
        mSignTextView.setText("点击签字");
    }

    @Override
    public void onClick(View v) {
        goSign();
    }

    private void goSign() {
        new BottomSignDialog.Builder(mContext).setConfirmStr("确认签名").setOnDialogClickListener(file -> {
            String localPath = file.getPath();
            if (mOnCommonSignWidgetListener != null) {
                mOnCommonSignWidgetListener.onOriginalSignFile(localPath);
            }
            upLoadImg(localPath);
        }).build().show();
    }

    private void upLoadImg(String localPath) {
        String key = toDuLoadImg(localPath);
        if (mOnCommonSignWidgetListener != null) {
            mOnCommonSignWidgetListener.onUploadSignReturn(true, key);
        }
        if (!mIsChangeSign) {
            mIsChangeSign = true;
            mSignTextView.setText("修改签字");
        }
    }

    private String toDuLoadImg(String localPath) {
        return "null";
    }

    public void setOnCommonSignWidgetListener(OnCommonSignWidgetListener onCommonSignWidgetListener) {
        mOnCommonSignWidgetListener = onCommonSignWidgetListener;
    }

    public interface OnCommonSignWidgetListener {

        /**
         * 本地文件路径
         *
         * @param localPath localPath
         */
        void onOriginalSignFile(String localPath);

        /**
         * 上传返回结果
         *
         * @param success 上传是否成功
         * @param key     返回文件
         */
        void onUploadSignReturn(boolean success, String key);
    }
}
