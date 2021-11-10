package com.sun.demo;

import android.app.Application;

import com.sun.db.entity.UserInfo;
import com.sun.db.table.manager.UserInfoManager;

/**
 * @author Harper
 * @date 2021/11/9
 * note:
 */
public class MainApplication extends Application implements UserInfoManager.OnUpdateUserInfoListener,
        UserInfoManager.OnGetCurrentUserInfoListener {

    private static MainApplication sInstance;
    private UserInfo mUserInfo;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static MainApplication getInstance() {
        return sInstance;
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
