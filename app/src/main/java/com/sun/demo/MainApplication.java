package com.sun.demo;

import android.app.Application;
import android.content.Context;

import com.sun.base.bean.TDevice;
import com.sun.base.net.NetWork;
import com.sun.base.net.NetWorks;
import com.sun.base.util.LogUtil;
import com.sun.base.util.RetrofitUtils;
import com.sun.db.entity.UserInfo;
import com.sun.db.table.manager.UserInfoManager;
import com.tencent.smtt.sdk.QbSdk;
import com.umeng.commonsdk.UMConfigure;

/**
 * @author Harper
 * @date 2021/11/9
 * note:
 */
public class MainApplication extends Application implements UserInfoManager.OnUpdateUserInfoListener,
        UserInfoManager.OnGetCurrentUserInfoListener {

    private UserInfo mUserInfo;

    @Override
    public void onCreate() {
        super.onCreate();
        Context context = MainApplication.this;
        TDevice.initTDevice(context);
        NetWorks.init(context);
        NetWork.init(context);
        RetrofitUtils.initRetrofit(context);
        //初始化LogUtil
        LogUtil.init(context, LogUtil.ALL);
        //初始化友盟SDK
        String umAppKey = context.getResources().getString(R.string.um_app_key);
        UMConfigure.init(this, umAppKey, "umeng", UMConfigure.DEVICE_TYPE_PHONE, "");
        initX5();
    }

    private void initX5() {
        QbSdk.initX5Environment(MainApplication.this, new QbSdk.PreInitCallback() {
            @Override
            public void onCoreInitFinished() {

            }

            @Override
            public void onViewInitFinished(boolean b) {

            }
        });
    }

    @Override
    public void onUserInfoUpdated(UserInfo userInfo) {
        mUserInfo = UserInfoManager.getInstance(this).getCurrentLoginUser();
    }

    @Override
    public UserInfo getCurrentUserInfo() {
        if (mUserInfo == null) {
            mUserInfo = UserInfoManager.getInstance(this).getCurrentLoginUser();
        }
        return mUserInfo;
    }
}
