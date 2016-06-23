package cn.gc.custviewfucker.views;

import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import cn.gc.custviewfucker.utils.MeasureUtil;

/**
 * Created by 宫成 on 16/5/8 下午9:56.
 */
public class BaseView extends View {

    protected Paint mPaint;
    protected int screenWidth;
    protected int screenHeight;

    public BaseView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        int[] screenDimen = MeasureUtil.getScreenDimen((Activity) context);
        screenWidth = screenDimen[0];
        screenHeight = screenDimen[1];
    }
}
