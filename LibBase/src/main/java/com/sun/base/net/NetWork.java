package com.sun.base.net;

import android.content.Context;

import com.sun.base.net.exception.ExceptionEngine;
import com.sun.base.net.response.Response;
import com.sun.base.util.RetrofitUtils;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;
import retrofit2.adapter.rxjava2.Result;

/**
 * @author: Harper
 * @date:   2021/11/16
 * @note:
 */
public class NetWork extends RetrofitUtils {

    private static NetWork instance;

    public static void init(Context context) {
        instance = new NetWork();
    }

    public static NetWork getInstance(){
        return instance;
    }

    public <T extends Response> Observable<Result<T>> commonSendRequest
            (Observable<Result<T>> observable) {
        return observable.map(new ServerResultFunc<>())
                .onErrorResumeNext(new HttpResultFunc<>())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private static class ServerResultFunc<T extends Response> implements Function<Result<T>, Result<T>> {
        @Override
        public Result<T> apply(@NonNull Result<T> tResult) throws Exception {
            if (tResult != null && tResult.isError() && (tResult.error() instanceof Exception)) {
                throw (Exception) tResult.error();
            } else if (tResult != null && tResult.response() != null && !tResult.response().isSuccessful()) {
                throw new HttpException(tResult.response());
            } else if (tResult == null || tResult.response() == null) {
                throw new NullPointerException("Result or Response is Null");
            } else {
                return tResult;
            }
        }
    }

    private static class HttpResultFunc<T> implements Function<Throwable, Observable<T>> {
        @Override
        public Observable<T> apply(Throwable throwable) {
            return Observable.error(ExceptionEngine.handleException(throwable));
        }
    }

}
