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
     * 服务端开发环境地址
     */
    private static final String DEV_SERVER_URL = "http://192.168.31.198:8080/";
    /**
     * 服务端测试环境地址
     */
    private static final String TEST_SERVER_URL = "http://192.168.31.198:8080/";
    /**
     * 服务端正式环境地址
     */
    private static final String RELEASE_SERVER_URL = "http://abc.xiaoshixue.com:6280/";

    //文件名(后缀，前缀为包名)用来标识服务端当前环境
    public static final String FILE_DEV = "_XIAO_SHI_DEV";
    public static final String FILE_TEST = "_XIAO_SHI_TEST";
    public static final String FILE_RELEASE = "_XIAO_SHI_RELEASE";

    //定义当前开发环境类型
    public enum Environment {
        DEV, //开发环境
        TEST, //测试环境
        RELEASE //正式环境
    }

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
     * 获取当前开发环境
     *
     * @param context
     * @return
     */
    public static Environment getCurrentEnvironment(Context context) {
        String serverUrl = getServerUrl(context);
        if (TextUtils.equals(serverUrl, DEV_SERVER_URL)) {
            return Environment.DEV;
        } else if (TextUtils.equals(serverUrl, TEST_SERVER_URL)) {
            return Environment.TEST;
        } else {
            return Environment.RELEASE;
        }
    }

    /**
     * 保存开发环境
     *
     * @param context
     * @param environment 需要保存的开发环境
     * @return
     */
    public static boolean saveEnvironment(Context context, Environment environment) {
        if (!TDevice.isApkDebugable()) {//只有debug包才可以保存
            return false;
        }
        Environment currentEnvironment = getCurrentEnvironment(context);
        if (environment == currentEnvironment) {//环境一致，就不需要保存了
            return false;
        }
        String sdcardPath = android.os.Environment.getExternalStorageDirectory().getAbsolutePath();
        String packageName = context.getPackageName();
        final String createFileName;
        final List<String> deleteFileNameList = new ArrayList<>();
        switch (environment) {
            case DEV:
                createFileName = packageName + FILE_DEV;
                deleteFileNameList.add(packageName + FILE_TEST);
                deleteFileNameList.add(packageName + FILE_RELEASE);
                break;
            case TEST:
                createFileName = packageName + FILE_TEST;
                deleteFileNameList.add(packageName + FILE_DEV);
                deleteFileNameList.add(packageName + FILE_RELEASE);
                break;
            case RELEASE:
                createFileName = packageName + FILE_RELEASE;
                deleteFileNameList.add(packageName + FILE_DEV);
                deleteFileNameList.add(packageName + FILE_TEST);
                break;
            default:
                createFileName = packageName + FILE_RELEASE;
                deleteFileNameList.add(packageName + FILE_DEV);
                deleteFileNameList.add(packageName + FILE_TEST);
                break;
        }
        if (!CollectionUtil.isEmpty(deleteFileNameList)) {
            for (String deleteFileName : deleteFileNameList) {
                FileUtil.delete(new File(sdcardPath, deleteFileName));
            }
        }
        return FileUtil.createFile(new File(sdcardPath, createFileName));
    }

    /**
     * [获取应用程序版本名称信息]
     * @param context context
     * @return 当前应用的版本名称
     */
    public static synchronized String getVersionName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    context.getPackageName(), 0);
            return packageInfo.versionName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
