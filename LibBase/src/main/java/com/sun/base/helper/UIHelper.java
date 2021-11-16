package com.sun.base.helper;


import android.content.Context;
import android.widget.Toast;

import com.sun.base.ui.widget.CommonToast;

/**
 * @author: Harper
 * @date: 2021/11/12
 * @note: 界面帮助类
 */
public final class UIHelper {

    private UIHelper() {
        throw new UnsupportedOperationException("unsupported operation");
    }

    /**
     * 显示Toast
     *
     * @param context
     * @param msg
     */
    public static void showToast(Context context, String msg) {
        showToast(context, msg, false);
    }

    /**
     * 显示Toast
     *
     * @param context
     * @param msg
     * @param isSuccess
     */
    public static void showToast(Context context, String msg, boolean isSuccess) {
        ToastHelper.showCommonToast(context, msg, isSuccess ? CommonToast.TYPE_CORRECT :
                CommonToast.TYPE_WARNING);
    }

    /**
     * 显示Toast
     *
     * @param context
     * @param msg
     */
    public static void showLongToast(Context context, String msg) {
        showLongToast(context, msg, false);
    }

    /**
     * 显示Toast
     *
     * @param context
     * @param msg
     * @param isSuccess
     */
    public static void showLongToast(Context context, String msg, boolean isSuccess) {
        ToastHelper.showCommonToast(context, msg, isSuccess ? CommonToast.TYPE_CORRECT :
                CommonToast.TYPE_WARNING, Toast.LENGTH_LONG);
    }

}
