package cn.gc.im6.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by 宫成 on 16/1/8 下午3:01.
 */
public class Toaster {
    static Context mContext;

    public static void register(Context context) {
        mContext = context;
    }


    public static void shortToast(String toastMsg) {
        if (mContext == null) {
            throw new IllegalStateException("Application里注册本类 , register()!");
        } else {
            Toast.makeText(mContext, toastMsg, Toast.LENGTH_SHORT).show();
        }
    }

    public static void shortToast(int resId) {
        if (mContext == null) {
            throw new IllegalStateException("Application里注册本类 , register()!");
        } else {
            shortToast(mContext.getString(resId));
        }
    }
}
