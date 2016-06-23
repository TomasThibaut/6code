package cn.gc.kandroid;

import android.app.Application;
import android.telephony.TelephonyManager;

/**
 * Created by 宫成 on 16/3/24 下午2:21.
 */
public class KApplication extends Application {
    private String imei;


    @Override public void onCreate() {
        super.onCreate();
        TelephonyManager telManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        imei = telManager.getDeviceId();
    }


    public String getImei() {
        return imei;
    }
}
