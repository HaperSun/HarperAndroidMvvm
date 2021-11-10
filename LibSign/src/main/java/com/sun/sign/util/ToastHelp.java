package com.sun.sign.util;

import android.content.Context;
import android.widget.Toast;

/**
 * @author Harper
 * @date 2021/11/10
 * note:
 */
public class ToastHelp {

    public static void show(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }
}
