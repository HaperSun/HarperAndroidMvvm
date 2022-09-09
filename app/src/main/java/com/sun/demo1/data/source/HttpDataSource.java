package com.sun.demo1.data.source;


import com.sun.base.http.BaseResponse;
import com.sun.demo1.entity.DemoEntity;

import io.reactivex.Observable;

/**
 * @author: Harper
 * @date: 2022/9/9
 * @note:
 */
public interface HttpDataSource {
    //模拟登录
    Observable<Object> login();

    //模拟上拉加载
    Observable<DemoEntity> loadMore();

    Observable<BaseResponse<DemoEntity>> demoGet();

    Observable<BaseResponse<DemoEntity>> demoPost(String catalog);


}
