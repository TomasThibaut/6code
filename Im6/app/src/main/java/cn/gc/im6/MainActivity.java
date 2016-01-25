package cn.gc.im6;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Toolbar;

import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.gc.im6.api.ApiUtil;
import cn.gc.im6.api.entity.GListEntity;
import cn.gc.im6.api.entity.GTListEntity;
import cn.gc.im6.ui.adapter.GListAdapter;
import cn.gc.im6.ui.adapter.GTListAdapter;
import cn.gc.im6.util.LogUtil;
import cn.gc.im6.util.Toaster;
import okhttp3.Call;

public class MainActivity extends Activity {

    @Bind(R.id.drawer_main)
    DrawerLayout mDrawer;
    @Bind(R.id.drawer_swipe)
    RelativeLayout ll_swipe;
    @Bind(R.id.rv_swipe_top)
    RecyclerView rv_top;
    @Bind(R.id.rv_swipe_bottom)
    RecyclerView rv_bottom;
    @Bind(R.id.toolbar_main)
    Toolbar mToolbar;

    private Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext = this;
        initView();
    }

    private void initView() {
        mToolbar.setNavigationIcon(R.mipmap.lobby_headerbar_leftbutton_more_normal);
        mToolbar.setNavigationOnClickListener(v -> toggleDrawer());

        RecyclerView.LayoutManager gLm = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        rv_top.setLayoutManager(gLm);

        RecyclerView.LayoutManager gTLm = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        rv_bottom.setLayoutManager(gTLm);
    }

    private void toggleDrawer() {
        if (mDrawer.isDrawerOpen(ll_swipe)) {
            mDrawer.closeDrawer(ll_swipe);
        } else {
            mDrawer.openDrawer(ll_swipe);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.i(mContext, "onResume()");
        drawerNet();

    }

    private void drawerNet() {
        //drawer热门游戏
        OkHttpUtils.post()
                    .url(ApiUtil.getGList())
                    .build()
                    .execute(new StringCallback() {
                        @Override
                        public void onError(Call call, Exception e) {
                            processError(e);
                        }

                        @Override
                        public void onResponse(String s) {
                            processData(s);
                        }
                    });
        //drawer列表
        OkHttpUtils.post()
                    .url(ApiUtil.getGTList())
                    .build()
                    .execute(new StringCallback() {
                        @Override
                        public void onError(Call call, Exception e) {
                            processError(e);
                        }

                        @Override
                        public void onResponse(String s) {
                            processTData(s);
                        }
                    });
    }

    /**
     * drawer列表
     */
    private void processTData(String s) {
        LogUtil.i(mContext, s);
        GTListEntity gTData = new Gson().fromJson(s, GTListEntity.class);
        rv_bottom.setAdapter(new GTListAdapter(mContext, gTData.getGameTypeList()));
    }

    /**
     * drawer热门游戏
     */
    private void processData(String s) {
        LogUtil.i(mContext, s);
        GListEntity gData = new Gson().fromJson(s, GListEntity.class);
        rv_top.setAdapter(new GListAdapter(mContext, gData.getGameList()));
    }

    private void processError(Exception e) {
        Toaster.shortToast(R.string.net_timeout);
        LogUtil.e(mContext, e + "");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
