package cn.gc.okhttpdemo.util;

import android.content.Context;
import android.util.Log;

/**
 * Created by 宫成 on 16/1/11 下午3:59.
 */
public class LogUtil {
    public static void i(Context context, String content) {
        Log.i(getTag(context), content);
    }

    private static String getTag(Context context) {
        return context.getClass().getSimpleName();
    }
}
