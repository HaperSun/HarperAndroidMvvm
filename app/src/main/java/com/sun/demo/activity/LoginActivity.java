package com.sun.demo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.sun.db.entity.UserInfo;
import com.sun.db.table.manager.UserInfoManager;
import com.sun.demo.R;
/**
 * @author: Harper
 * @date:   2021/11/10
 * @note: greendao 关于 userInfo 的一些操作
 */
public class LoginActivity extends AppCompatActivity {

    public static void startActivity(Context context){
        Intent intent = new Intent(context,LoginActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginSuccess();
//        logout();
    }

    /**
     * 登陆成功后保存数据到历史记录中去
     */
    private void loginSuccess() {
        UserInfo userInfo = new UserInfo("张三", "88888", "", 198839, UserInfo.LoginState.LOGIN);
        UserInfoManager.getInstance(this).loginAndSaveUserInfo(userInfo);
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
}