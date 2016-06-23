package cn.gc.custviewfucker.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;

/**
 * Created by 宫成 on 16/5/8 下午11:07.
 */
public class MeasureUtil {
    public static int[] getScreenDimen(Activity activity) {
        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int[] arr = new int[2];
        arr[0] = metrics.widthPixels;
        arr[1] = metrics.heightPixels;
        return arr;
    }

    /**
     * px 2 dp
     */
    public static int px2dx(Context context, int px) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, px, context.getResources().getDisplayMetrics());
    }

    /**
     * dp 2 px
     */
    public static int dx2px(Context context, int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }

}
