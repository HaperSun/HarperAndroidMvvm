package com.sun.base.helper;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.LayoutRes;
import androidx.annotation.StringRes;

import com.sun.base.R;
import com.sun.base.ui.widget.CommonToast;

/**
 * @author: Harper
 * @date:   2021/11/12
 * @note:
 */
public class ToastHelper {

    private static Toast sToast;
    private static CommonToast sCommonToast;

    private static Toast getToast(Context context) {
        if (sToast == null) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                return null;
            }
            sToast = new Toast(applicationContext);
            sToast.setDuration(Toast.LENGTH_SHORT);
            sToast.setView(LayoutInflater.from(applicationContext).inflate(R.layout.layout_toast, null));
        } else {
            sToast.cancel();
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                return null;
            }
            sToast = new Toast(applicationContext);
            sToast.setDuration(Toast.LENGTH_SHORT);
            sToast.setView(LayoutInflater.from(applicationContext).inflate(R.layout.layout_toast, null));
        }
        return sToast;
    }

    public static void showCustomToast(Context context, String msg) {
        showCustomToast(context, msg, R.layout.layout_toast, R.id.tv_content, Toast.LENGTH_SHORT);
    }

    public static void showCustomToast(Context context, String msg, @LayoutRes int layout, int textViewId, int duration) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            return;
        }
        if (sToast != null) {
            sToast.cancel();
        }
        sToast = new Toast(applicationContext);
        sToast.setDuration(Toast.LENGTH_SHORT);
        View view = LayoutInflater.from(applicationContext).inflate(layout, null);
        sToast.setView(view);
        sToast.setGravity(Gravity.CENTER, 0, 0);
        TextView textView = view.findViewById(textViewId);
        textView.setText(msg);
        sToast.show();
    }

    public static void showToast(Context context, String msg) {
        try {
            Toast toast = getToast(context);
            assert toast != null;
            TextView textView = toast.getView().findViewById(R.id.tv_content);
            textView.setText(msg);
            toast.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static CommonToast getCommonToast(Context context) {
        try {
            if (sCommonToast == null) {
                Context applicationContext = context.getApplicationContext();
                sCommonToast = new CommonToast.Builder(applicationContext)
                        .setGravity(Gravity.CENTER, 0, 0)
                        .setDuration(Toast.LENGTH_SHORT)
                        .build();
            } else {
                sCommonToast.cancel();
                Context applicationContext = context.getApplicationContext();
                sCommonToast = new CommonToast.Builder(applicationContext)
                        .setGravity(Gravity.CENTER, 0, 0)
                        .setDuration(Toast.LENGTH_SHORT)
                        .build();
            }
        } catch (Exception e) {

        }
        return sCommonToast;
    }


    public static void showCommonToast(Context context, @StringRes int resId) {
        try {
            showCommonToast(context, resId, CommonToast.TYPE_WARNING);
        } catch (Exception e) {

        }
    }

    public static void showCommonToast(Context context, CharSequence msg) {
        try {
            showCommonToast(context, msg, CommonToast.TYPE_WARNING);
        } catch (Exception e) {

        }
    }

    public static void showCommonToast(Context context, @StringRes int resId, @CommonToast.TOAST_TYPE int type) {
        try {
            showCommonToast(context, context.getString(resId), type);
        } catch (Exception e) {

        }
    }

    public static void showCommonToast(Context context, CharSequence msg, @CommonToast.TOAST_TYPE int type) {
        try {
            showCommonToast(context, msg, type, Toast.LENGTH_SHORT);
        } catch (Exception e) {

        }
    }

    public static void showCommonToast(Context context, CharSequence msg, @CommonToast.TOAST_TYPE int type, int duration) {
        try {
            CommonToast commonToast = getCommonToast(context);
            commonToast.setText(msg);
            commonToast.setType(type);
            commonToast.setDuration(duration);
            commonToast.show();
        } catch (Exception e) {

        }
    }

}
