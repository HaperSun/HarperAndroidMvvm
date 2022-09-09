package com.sun.demo1.app;

import com.sun.base.base.BaseApplication;
import com.sun.base.bean.AppConfig;
import com.sun.base.crash.CaocConfig;
import com.sun.base.util.AppUtil;
import com.sun.base.util.KLog;
import com.sun.demo1.BuildConfig;
import com.sun.demo1.R;
import com.sun.demo1.ui.login.LoginActivity;

public class MainApplication extends BaseApplication {

    private static MainApplication ctx;

    @Override
    public void onCreate() {
        super.onCreate();
        ctx = this;
        AppUtil.init(getBaseConfig());
        //是否开启打印日志
        KLog.init(BuildConfig.DEBUG);
        //初始化全局异常崩溃
        initCrash();
    }

    private void initCrash() {
        CaocConfig.Builder.create()
                //背景模式,开启沉浸式
                .backgroundMode(CaocConfig.BACKGROUND_MODE_SILENT)
                //是否启动全局异常捕获
                .enabled(true)
                //是否显示错误详细信息
                .showErrorDetails(true)
                //是否显示重启按钮
                .showRestartButton(true)
                //是否跟踪Activity
                .trackActivities(true)
                //崩溃的间隔时间(毫秒)
                .minTimeBetweenCrashesMs(2000)
                //错误图标
                .errorDrawable(R.mipmap.ic_launcher)
                //重新启动后的activity
                .restartActivity(LoginActivity.class)
                //崩溃后的错误activity
//                .errorActivity(YourCustomErrorActivity.class)
                //崩溃后的错误监听
//                .eventListener(new YourCustomEventListener())
                .apply();
    }

    private AppConfig getBaseConfig() {
        return new AppConfig(ctx, BuildConfig.APPLICATION_ID, BuildConfig.VERSION_CODE,
                BuildConfig.VERSION_NAME, BuildConfig.Base_URL);
    }
}
