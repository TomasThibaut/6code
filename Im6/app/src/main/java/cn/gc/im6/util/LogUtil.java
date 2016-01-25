package cn.gc.im6.util;

import android.content.Context;
import android.util.Log;

/**
 * Created by 宫成 on 16/1/11 下午3:59.
 */
public class LogUtil {
    public static boolean idDebug = true;

    public static void i(Context context, String content) {
        if (idDebug)
            Log.i(getTag(context), content);
    }

    public static void e(Context context, String content) {
        if (idDebug)
            Log.e(getTag(context), content);
    }

    private static String getTag(Context context) {
        return context.getClass().getSimpleName();
    }
}
