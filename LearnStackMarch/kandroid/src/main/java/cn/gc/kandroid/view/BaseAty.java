package cn.gc.kandroid.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import cn.gc.kandroid.core.ActionImpl;

/**
 * Created by 宫成 on 16/3/29 上午10:33.
 */
public class BaseAty extends AppCompatActivity {

    protected Context mContext;
    protected ActionImpl mAction;
    protected ActionBar mActionBar;


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAction = new ActionImpl(this);
        mActionBar = getSupportActionBar();
    }
}
