package com.sun.demo.activity;

import androidx.databinding.ViewDataBinding;

import android.content.Context;
import android.content.Intent;

import com.sun.common.toast.ToastHelper;
import com.sun.base.net.exception.ApiException;
import com.sun.base.ui.activity.BaseMvpActivity;
import com.sun.common.toast.CustomToast;
import com.sun.db.entity.UserInfo;
import com.sun.db.table.manager.UserInfoManager;
import com.sun.demo.R;
import com.sun.demo.databinding.ActivityLoginBinding;
import com.sun.demo.iview.LoginView;
import com.sun.demo.model.response.LoginResponse;
import com.sun.demo.present.LoginPresenter;

/**
 * @author: Harper
 * @date: 2021/11/10
 * @note: greendao 关于 userInfo 的一些操作
 */
public class LoginActivity extends BaseMvpActivity implements LoginView {

    private LoginPresenter mLoginPresenter;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    @Override
    public int layoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        ViewDataBinding viewDataBinding = getDataBinding();
        if (viewDataBinding != null) {
            ActivityLoginBinding binding = (ActivityLoginBinding) viewDataBinding;
            binding.login.setOnClickListener(v -> doLogin());
            binding.commonToast.setOnClickListener(v -> ToastHelper.showCommonToast(this, R.string.copy_success));
            binding.customToast.setOnClickListener(v -> ToastHelper.showCustomToast(this, R.string.copy_success));
        }
    }

    @Override
    public void initData() {
        if (mLoginPresenter == null) {
            mLoginPresenter = new LoginPresenter(this);
        }
    }

    private void doLogin() {
        mLoginPresenter.getLoginInfo("15556528693", "888888");
    }

    /**
     * 退出登录
     */
    private void logout() {
        //只是将该用户的登录状态置为登出，当入参是true时，也删除改用户本地记录的密码
        UserInfoManager.getInstance(this).logout(false);
        //直接将用户的信息给清除了
        UserInfoManager.getInstance(this).clear();
    }


    @Override
    public void onAtLoginStart() {

    }

    @Override
    public void onAtLoginReturned(LoginResponse response) {
        if (response != null && response.code == 1) {
            LoginResponse.Object object = response.object;
            if (object != null) {
                //陆成功后保存数据到历史记录中去
                UserInfo userInfo = new UserInfo(object.userName, object.password, object.token, object.id, UserInfo.LoginState.LOGIN);
                UserInfoManager.getInstance(this).loginAndSaveUserInfo(userInfo);
                ToastHelper.showCustomToast(this, "登陆成功", CustomToast.CORRECT);
            }
        }
    }

    @Override
    public void onAtLoginError(ApiException e) {

    }
}