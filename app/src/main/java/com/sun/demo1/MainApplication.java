package com.sun.demo1;

import android.app.Application;
import android.content.Context;

import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;

/**
 * @author Harper
 * @date 2021/11/9
 * note:
 */
public class MainApplication extends Application {

    private static MainApplication ctx;

    @Override
    public void onCreate() {
        super.onCreate();
        ctx = MainApplication.this;
        initUmSdk();
    }

    private void initUmSdk() {
        UMConfigure.init(ctx, "5cbad65a570df39ea70012b8", "Umeng", UMConfigure.DEVICE_TYPE_PHONE, null);
        MobclickAgent.setPageCollectionMode(MobclickAgent.PageMode.AUTO);
        PlatformConfig.setWeixin("wx18719ce4d83c714a", "c766c2b5d6151ccf926dd03cbc8e56a5");
        PlatformConfig.setWXFileProvider("com.sun.demo1.fileprovider");
    }

    public static MainApplication getInstance() {
        return ctx;
    }

    public static Context getContext() {
        return ctx;
    }
}
