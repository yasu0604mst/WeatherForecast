package com.fukuoka.beatc.weatherforecast.domain.usecase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ted on 2017/07/01.
 */

public abstract class UseCase<T> {
    //スレッドをキュー処理できるようにする
    private ExecutorService mExecutorService = Executors.newSingleThreadExecutor();

    public void start(final T params) {
        mExecutorService.submit(new Runnable() {
           @Override
            public void run() {
               call(params);
           }
        });
    }
    //スレッド内でコールされるメソッド
    abstract protected void call(T params);
    abstract protected void execute(String user, FollowerListUseCase.FollowerListUseCaseCallback callback);
}
