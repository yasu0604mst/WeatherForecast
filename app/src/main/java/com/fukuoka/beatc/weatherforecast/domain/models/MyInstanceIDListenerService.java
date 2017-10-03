package com.fukuoka.beatc.weatherforecast.domain.models;

/**
 * Created by ted on 2017/10/02.
 */
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
public class MyInstanceIDListenerService extends FirebaseInstanceIdService {
    private static final String TAG = MyInstanceIDListenerService.class.getSimpleName();

    @Override
    public void onTokenRefresh() {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);
        //サーバーにrefreshedTokenを送信し初期設定を行う
        //※任意メソッド
        //sendRegistrationToServer(refreshedToken);
    }
}