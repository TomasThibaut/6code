package cn.gc.okhttpdemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;

import java.io.IOException;

import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.gc.okhttpdemo.entity.GameTypeEntity;
import cn.gc.okhttpdemo.util.LogUtil;
import cn.gc.okhttpdemo.util.Toaster;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends Activity {

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //注册Toast工具类
        Toaster.register(this);
        mContext = this;

    }

    //直接使用
    @OnClick(R.id.btn_normal)
    void onNormalUse() {
        /**构建okHttp客户端 , 用来完成请求Server操作*/
        OkHttpClient mClient = new OkHttpClient();
        /**构建请求对象*/
        Request request = new Request.Builder()
//                    .addHeader(headName,headBody);//添加请求头
                    .url("http://dev.huanpeng.com/a/getGTList.php")
                    .build();

        Call call = mClient.newCall(request);
        //异步请求用这个
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                processError(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                processData(response);
            }
        });

    }

    private void processData(Response response) throws IOException {
        LogUtil.i(mContext, response.body().string());
        GameTypeEntity data = new Gson().fromJson(response.body().string(), GameTypeEntity.class);
    }

    private void processError(IOException e) {
        LogUtil.i(mContext, "报错" + e);
    }

    @OnClick(R.id.btn_normal_)
    void onUnNormalUser() {

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
