package com.sun.demo1.data.source.local;


import com.sun.base.util.SPUtil;
import com.sun.demo1.data.source.LocalDataSource;

/**
 * @author: Harper
 * @date: 2022/9/9
 * @note: 本地数据源，可配合Room框架使用
 */
public class LocalDataSourceImpl implements LocalDataSource {
    private volatile static LocalDataSourceImpl INSTANCE = null;

    public static LocalDataSourceImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (LocalDataSourceImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LocalDataSourceImpl();
                }
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    private LocalDataSourceImpl() {
        //数据库Helper构建
    }

    @Override
    public void saveUserName(String userName) {
        SPUtil.getInstance().put("UserName", userName);
    }

    @Override
    public void savePassword(String password) {
        SPUtil.getInstance().put("password", password);
    }

    @Override
    public String getUserName() {
        return SPUtil.getInstance().getString("UserName");
    }

    @Override
    public String getPassword() {
        return SPUtil.getInstance().getString("password");
    }
}
