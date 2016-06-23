package cn.gc.demo01;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 宫成 on 16/2/17 上午10:44.
 */
public class MyAdapter extends BaseAdapter {

    private List<Integer> ids;
    private Context mContext;
    private LayoutInflater mInflater;
    private boolean isShowingCheckBox;

    public MyAdapter(Context context, List<Integer> ids) {
        mContext = context;
        this.ids = ids;
        mInflater = LayoutInflater.from(context);
        isShowingCheckBox = false;
    }

    @Override
    public int getCount() {
        return ids.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_right, parent, false);
        }
        TextView tv_id = (TextView) convertView.findViewById(R.id.tv_id);
        tv_id.setText(ids.get(position) + "");

        LinearLayout ll_anim = (LinearLayout) convertView.findViewById(R.id.ll_anim);


        final CheckBox cBox = (CheckBox) convertView.findViewById(R.id.cBox);
        float checkBoxWidth = cBox.getMeasuredWidth();
        if (isShowingCheckBox) {
//            ObjectAnimator oa = ObjectAnimator.ofFloat(cBox, "alpha", 0, 255);
            /**
             * 移动图片位置
             */
            ObjectAnimator oa2 = ObjectAnimator.ofFloat(ll_anim, "translationX", 0, cBox.getMeasuredWidth());
            oa2.setDuration(1000);
            oa2.start();
            final AnimatorListenerAdapter adapter = new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    /**
                     * 当动画完成的时候显示CheckBox
                     */
                    cBox.setVisibility(View.VISIBLE);
                }
            };
            oa2.addListener(adapter);

        } else {
//            ObjectAnimator oa = ObjectAnimator.ofFloat(cBox, "alpha", 255, 0);
            ObjectAnimator oa2 = ObjectAnimator.ofFloat(ll_anim, "translationX", cBox.getMeasuredWidth(), 0);
            oa2.setDuration(1000);
            oa2.start();
            AnimatorListenerAdapter adapter = new AnimatorListenerAdapter() {
                @Override
                public void onAnimationStart(Animator animation) {
                    cBox.setVisibility(View.GONE);
                }
            };
            oa2.addListener(adapter);
        }
        return convertView;
    }

    public void showCheckBox() {
        isShowingCheckBox = true;
    }

    public void hideCheckBox() {
        isShowingCheckBox = false;
    }
}
