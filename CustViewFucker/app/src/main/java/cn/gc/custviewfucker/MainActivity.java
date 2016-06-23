package cn.gc.custviewfucker;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.gc.custviewfucker.fgts.CanvasFgt;
import cn.gc.custviewfucker.fgts.PaintFgt;

public class MainActivity extends BaseActivity {
    @Bind(R.id.fraLayout_main)
    FrameLayout mFraLayout;

    Fragment fgt1, fgt2;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        fgt1 = new PaintFgt();
        fgt2 = new CanvasFgt();
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.fraLayout_main, fgt1).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_paint:
                fragmentManager.beginTransaction().replace(R.id.fraLayout_main, fgt1).commit();
                break;
            case R.id.menu_canvas:
                fragmentManager.beginTransaction().replace(R.id.fraLayout_main, fgt2).commit();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
