package com.sun.demo1.activity;

import android.content.Context;
import android.content.Intent;

import com.sun.base.net.exception.ApiException;
import com.sun.base.ui.activity.BaseMvpActivity;
import com.sun.common.toast.CustomToast;
import com.sun.common.toast.ToastHelper;
import com.sun.db.entity.UserInfo;
import com.sun.db.table.manager.UserInfoManager;
import com.sun.demo1.R;
import com.sun.demo1.databinding.ActivityLoginBinding;
import com.sun.demo1.iview.LoginView;
import com.sun.demo1.model.response.LoginResponse;
import com.sun.demo1.present.LoginPresenter;
import com.sun.demo1.tab.style.ButtonData;
import com.sun.demo1.tab.style.ButtonEventListener;
import com.sun.demo1.tab.style.SectorMenuButton;
import com.sun.img.load.ImageLoader;
import com.sun.img.preview.ImagePreviewActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Harper
 * @date: 2021/11/10
 * @note: greendao 关于 userInfo 的一些操作
 */
public class LoginActivity extends BaseMvpActivity implements LoginView {

    private LoginPresenter mLoginPresenter;
    private SectorMenuButton mSectorMenuButton;

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
        ActivityLoginBinding binding = (ActivityLoginBinding) mViewDataBinding;
        binding.login.setOnClickListener(v -> doLogin());
        binding.commonToast.setOnClickListener(v -> ToastHelper.showCommonToast(this, R.string.copy_success));
        binding.customToast.setOnClickListener(v -> ToastHelper.showCustomToast(this, R.string.copy_success));
        mSectorMenuButton = binding.sectorMenuButton;
        String img1 = "https://qiniu.fxgkpt.com/hycg/1639356784663.jpg";
        String img2 = "http://pic.ntimg.cn/file/20180211/7259105_125622777789_2.jpg";
        ImageLoader.getInstance().loadImage(img2, binding.imgView);
        binding.imgView.setOnClickListener(v -> ImagePreviewActivity.actionStart(this, img2));
    }

    @Override
    public void initData() {
        if (mLoginPresenter == null) {
            mLoginPresenter = new LoginPresenter(this);
        }
        initSectorMenuButton();
    }

    private void initSectorMenuButton() {
        final List<ButtonData> buttonDatas = new ArrayList<>();
        int[] drawable = {R.mipmap.touming, R.mipmap.danger_upload_ionc, R.mipmap.accident_upload_icon};
        for (int i = 0; i < 3; i++) {
            ButtonData buttonData = ButtonData.buildIconButton(this, drawable[i], 0);
            buttonDatas.add(buttonData);
        }
        mSectorMenuButton.setButtonDatas(buttonDatas);
        setListener(mSectorMenuButton);
    }

    private void setListener(final SectorMenuButton button) {
        button.setButtonEventListener(new ButtonEventListener() {
            @Override
            public void onButtonClicked(int index) {
                if (index == 1) {
                    ToastHelper.showCommonToast(LoginActivity.this, R.string.copy_success);
                } else {
                    ToastHelper.showCommonToast(LoginActivity.this, R.string.copy_success);
                }
            }

            @Override
            public void onExpand() {

            }

            @Override
            public void onCollapse() {
            }
        });
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