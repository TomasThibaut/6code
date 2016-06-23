package cn.gc.learnstackmarch;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;
import butterknife.Bind;
import butterknife.ButterKnife;
import cn.gc.learnstackmarch.ui.BaseAty;

public class MainActivity extends BaseAty {

    @Bind(R.id.content_frame) FrameLayout contentFrame;
    @Bind(R.id.drawer_frame) FrameLayout drawerFrame;
    @Bind(R.id.blur_img) ImageView blurImg;
    @Bind(R.id.drawer_layout) DrawerLayout mDrawerLayout;

    private ActionBarDrawerToggle mDrawerToggle;


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        // TODO: 16/3/23 setActionBar
        //mDrawerLayout.setScrimColor();

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open,
                R.string.drawer_close);
    }


    @Override public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
