package cn.gc.learnstackmarch.ui;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import cn.gc.learnstackmarch.R;

/**
 * 抽取共性 , toolbar是相同的 , 下拉刷新是相同的
 * protected权限: 该方法可以被同包（java.lang）下和它（java.lang.Object）的子类访问
 *
 * TODO 2016年03月23日15:25:11 把actionbar 换成 toolbar
 */
public class BaseAty extends AppCompatActivity {

    protected ActionBar mActionBar;


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeToolbar();
    }


    private void initializeToolbar() {
        mActionBar = getActionBar();
        if (mActionBar == null) {
            return;
            //throw new IllegalStateException("ActionBar对象为空");
        }
        mActionBar.setDisplayHomeAsUpEnabled(true);
    }


    public void setTitle(int resId) {
        mActionBar.setTitle(resId);
    }


    public void setTitle(CharSequence text) {
        mActionBar.setTitle(text);
    }


    @Override public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_base_aty, menu);
        return true;
    }


    @Override public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }
}
