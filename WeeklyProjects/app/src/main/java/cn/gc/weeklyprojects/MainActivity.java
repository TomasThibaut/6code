package cn.gc.weeklyprojects;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    /*@Bind(R.id.collapsingToolbarLayout)
    CollapsingToolbarLayout cToolbarLayout;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
//        mToolbar.setTitle("hello , world");
//        mToolbar.setLogo(R.mipmap.ic_launcher);
//        cToolbarLayout.setTitle("hell world");
//        setupDrawerContent();
        init();
    }

    private void init() {


    }

}
