package cn.gc.custviewfucker.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;

import cn.gc.custviewfucker.R;

/**
 * Created by 宫成 on 16/5/8 下午11:43.
 *
 */
public class DiaoView extends BaseView {
    Path mPath;
    Canvas mCanvas;
    Bitmap bgBmp;
    Bitmap fgBmp;
    Paint fgPaint;

    public DiaoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        mPath = new Path();
        bgBmp = BitmapFactory.decodeResource(context.getResources(), R.mipmap.aige03);
        fgBmp = Bitmap.createBitmap(screenWidth, screenHeight, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(fgBmp);
        fgPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        fgPaint.setColor(Color.GRAY);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bgBmp, 0, 0, mPaint);
        mCanvas.drawBitmap(fgBmp, 0, 0, fgPaint);

    }
}
