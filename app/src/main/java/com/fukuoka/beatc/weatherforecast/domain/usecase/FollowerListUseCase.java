package com.fukuoka.beatc.weatherforecast.domain.usecase;

import android.support.annotation.NonNull;

import com.fukuoka.beatc.weatherforecast.domain.entity.Product;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ted on 2017/07/01.
 */

public class FollowerListUseCase extends UseCase<String> {
    private FollowerListUseCaseCallback mCallback;
    @Override
    public void execute(String user, FollowerListUseCaseCallback callback){
        mCallback = callback;
        this.start(user); // （1）ExecutorServiceのスレッド経由でcall()が呼ばれる
    }
    @Override
    protected void call(String user) {
        //(2)　Modelからデータ取得、バリデーション等のロジック処理
        //省略

        Collection usersCollection = new Collection() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @NonNull
            @Override
            public Iterator iterator() {
                return null;
            }

            @NonNull
            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @NonNull
            @Override
            public Object[] toArray(@NonNull Object[] a) {
                return new Object[0];
            }

            @Override
            public boolean add(Object o) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(@NonNull Collection c) {
                return false;
            }

            @Override
            public boolean addAll(@NonNull Collection c) {
                return false;
            }

            @Override
            public boolean removeAll(@NonNull Collection c) {
                return false;
            }

            @Override
            public boolean retainAll(@NonNull Collection c) {
                return false;
            }

            @Override
            public void clear() {

            }
        };

        //(3)処理後はUIThread(PostExecutionThread)にCallbackを返す
        //mPostexecutionThread.post(() ->{mCallback.onUserListLoaded(usersCollection);});
    }
    public static interface FollowerListUseCaseCallback {
        void onUserListLoaded(final Collection<Product> usersCollection);
        void onError();
    }

}
