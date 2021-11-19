package com.sun.base.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

import com.sun.base.R;
import com.sun.base.bean.TDevice;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Harper
 * @date:   2021/11/12
 * @note:
 */
public abstract class BaseUtil {

    /**
     * 获取服务端地址
     *
     * @param context
     * @return
     */
    public static String getServerUrl(Context context) {
        return context.getResources().getString(R.string.server_url);
    }


    /**
     * 是否是测试环境，只要不是正式环境就认为是测试环境
     *
     * @param context
     * @return
     */
    public static boolean isTestApi(Context context) {
        return context.getResources().getBoolean(R.bool.isTest);
    }

    /**
     * [获取应用程序版本名称信息]
     * @param context context
     * @return 当前应用的版本名称
     */
    public static synchronized String getVersionName(Context context) {
        return context.getResources().getString(R.string.version_name);
    }

    /**
     * [获取应用程序版本名称信息]
     * @param context context
     * @return 当前应用的版本名称
     */
    public static synchronized String getPackageName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    context.getPackageName(), 0);
            return packageInfo.packageName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
