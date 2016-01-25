package cn.gc.im6;

import android.app.Application;

import com.zhy.http.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import cn.gc.im6.util.Toaster;

/**
 * Created by 宫成 on 16/1/21 下午3:40.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Toaster.register(this);
        OkHttpUtils.getInstance()
                    .debug("666Debug")
                    .setConnectTimeout(10000, TimeUnit.MILLISECONDS);
    }
}
