package com.sun.demo1.data.source;

/**
 * @author: Harper
 * @date: 2022/9/9
 * @note:
 */
public interface LocalDataSource {
    /**
     * 保存用户名
     */
    void saveUserName(String userName);

    /**
     * 保存用户密码
     */

    void savePassword(String password);

    /**
     * 获取用户名
     */
    String getUserName();

    /**
     * 获取用户密码
     */
    String getPassword();
}
