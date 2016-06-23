package cn.gc.custviewfucker.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ProgressBar;

import cn.gc.custviewfucker.R;
import cn.gc.custviewfucker.utils.MeasureUtil;

/**
 * Created by 宫成 on 16/5/21 上午6:57.
 */
public class GcProgressBar extends ProgressBar {

    private static final int DEFAULT_UNREACH_COLOR = Color.DKGRAY;
    private static final int DEFAULT_UNREACH_HEIGHT = 2;
    private static final int DEFAULT_REACH_COLOR = Color.BLACK;
    private static final int DEFAULT_REACH_HEIGHT = 2;
    private static final int DEFAULT_TEXT_COLOR = Color.BLACK;
    private static final int DEFAULT_TEXT_SIZE = 10;
    private static final int DEFAULT_TEXT_OFFSET = 10;


    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public GcProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.progressbar);
        ta.getDimension(R.styleable.progressbar_progress_text_size, MeasureUtil.px2dx(context, DEFAULT_TEXT_SIZE));
    }


}
