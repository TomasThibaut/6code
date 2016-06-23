package cn.gc.custviewfucker.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;

import cn.gc.custviewfucker.bo.PorterDuffBO;

/**
 * Created by 宫成 on 16/5/8 下午10:58.
 */
public class PorterDuffView extends BaseView {

    private static final PorterDuff.Mode MODE = PorterDuff.Mode.ADD;
    PorterDuffBO porterDuffBO;
    PorterDuffXfermode xfermode;

    public PorterDuffView(Context context, AttributeSet attrs) {
        super(context, attrs);
        porterDuffBO = new PorterDuffBO();
        xfermode = new PorterDuffXfermode(MODE);

        calculate(context);
    }

    int s_l, s_t, d_l, d_t, rectX, rectY;
    private static final int RECT_SIZE_SMALL = 400;// 左右上方示例渐变正方形的尺寸大小
    private static final int RECT_SIZE_BIG = 800;// 中间测试渐变正方形的尺寸大小

    private void calculate(Context context) {

        // 计算左上方正方形原点坐标
        s_l = 0;
        s_t = 0;

        // 计算右上方正方形原点坐标
        d_l = screenWidth - RECT_SIZE_SMALL;
        d_t = 0;

        // 计算中间方正方形原点坐标
        rectX = screenWidth / 2 - RECT_SIZE_BIG / 2;
        rectY = RECT_SIZE_SMALL + (screenHeight - RECT_SIZE_SMALL) / 2 - RECT_SIZE_BIG / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLACK);
        // 设置业务对象尺寸值计算生成左右上方的渐变方形
        porterDuffBO.setSize(RECT_SIZE_SMALL);
        /**
         * 画出左右上方两个正方形
         * 其中左边的的为src右边的为dis
         */
        canvas.drawBitmap(porterDuffBO.initSrcBitmap(), s_l, s_t, mPaint);
        canvas.drawBitmap(porterDuffBO.initDisBitmap(), d_l, d_t, mPaint);
         /*
         * 将绘制操作保存到新的图层（更官方的说法应该是离屏缓存）我们将在1/3中学习到Canvas的全部用法这里就先follow me
         */
        int sc = canvas.saveLayer(0, 0, screenWidth, screenHeight, null, Canvas.ALL_SAVE_FLAG);

        // 重新设置业务对象尺寸值计算生成中间的渐变方形
        porterDuffBO.setSize(RECT_SIZE_BIG);

        // 先绘制dis目标图
        canvas.drawBitmap(porterDuffBO.initDisBitmap(), rectX, rectY, mPaint);

        // 设置混合模式
        mPaint.setXfermode(xfermode);

        // 再绘制src源图
        canvas.drawBitmap(porterDuffBO.initSrcBitmap(), rectX, rectY, mPaint);

        // 还原混合模式
        mPaint.setXfermode(null);

        // 还原画布
        canvas.restoreToCount(sc);
    }
}
