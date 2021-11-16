package com.sun.demo;

import android.app.Application;

import com.sun.base.bean.TDevice;
import com.sun.base.net.NetWork;
import com.sun.base.net.NetWorks;
import com.sun.base.util.LogUtil;
import com.sun.base.util.RetrofitUtils;
import com.sun.db.entity.UserInfo;
import com.sun.db.table.manager.UserInfoManager;

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
        TDevice.initTDevice(this);
        NetWorks.init(this);
        NetWork.init(this);
        RetrofitUtils.initRetrofit(this);
        LogUtil.init(this, BuildConfig.DEBUG
                || getResources().getBoolean(R.bool.isTest));
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
