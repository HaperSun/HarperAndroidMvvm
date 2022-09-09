package com.sun.demo1.app;


import com.sun.demo1.data.DemoRepository;
import com.sun.demo1.data.source.HttpDataSource;
import com.sun.demo1.data.source.LocalDataSource;
import com.sun.demo1.data.source.http.HttpDataSourceImpl;
import com.sun.demo1.data.source.http.service.DemoApiService;
import com.sun.demo1.data.source.local.LocalDataSourceImpl;
import com.sun.demo1.utils.RetrofitClient;

/**
 * @author: Harper
 * @date: 2022/9/9
 * @note: 注入全局的数据仓库，可以考虑使用Dagger2。（根据项目实际情况搭建，千万不要为了架构而架构）
 */
public class Injection {
    public static DemoRepository provideDemoRepository() {
        //网络API服务
        DemoApiService apiService = RetrofitClient.getInstance().create(DemoApiService.class);
        //网络数据源
        HttpDataSource httpDataSource = HttpDataSourceImpl.getInstance(apiService);
        //本地数据源
        LocalDataSource localDataSource = LocalDataSourceImpl.getInstance();
        //两条分支组成一个数据仓库
        return DemoRepository.getInstance(httpDataSource, localDataSource);
    }
}
