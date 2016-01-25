package cn.gc.im6.util;

import android.content.Context;
import android.content.SharedPreferences;
import cn.gc.im6.R;

/**
 * Created by 宫成 on 16/1/8 下午2:48.
 */
public class SPUtil {
    static SharedPreferences sp;

    public static void setBoolean(Context context, String key, Boolean value) {
        if (sp == null) {
            sp = context.getSharedPreferences(context.getString(R.string.SPKey), Context.MODE_PRIVATE);
        }
        sp.edit().putBoolean(key, value).apply();
    }

    public static boolean getBoolean(Context context, String key, Boolean defValue) {
        if (sp == null) {
            sp = context.getSharedPreferences(context.getString(R.string.SPKey), Context.MODE_PRIVATE);
        }
        return sp.getBoolean(key, defValue);
    }
}
