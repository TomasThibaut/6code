package cn.gc.okhttpdemo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.gc.okhttpdemo.util.LogUtil;
import cn.gc.okhttpdemo.util.Toaster;


public class MainActivity extends Activity {

    private Context mContext;

    @Bind(R.id.iv_main)
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //注册Toast工具类
        Toaster.register(this);
        mContext = this;
        mHandler = new MyHandler();
    }

    //直接使用
    @OnClick(R.id.btn_normal)
    void onNormalUse() {
        OkHttpClient mClient = new OkHttpClient();
        FormEncodingBuilder builder = new FormEncodingBuilder();
        Request request = new Request.Builder()
                    .url("http://ww3.sinaimg.cn/large/610dc034jw1f070hyadzkj20p90gwq6v.jpg")
                    .build();

        Call call = mClient.newCall(request);
        //异步请求用这个
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                processError(e);
            }

            @Override
            public void onResponse(Response response) throws IOException {
                try {
                    InputStream is = response.body().byteStream();
                    bitmap = BitmapFactory.decodeStream(is);
                    mHandler.sendEmptyMessage(1);
                    processData(response);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    Bitmap bitmap;


    private MyHandler mHandler;

    class MyHandler extends android.os.Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    Toast.makeText(mContext, "aaa", Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    if (bitmap != null)
                        iv.setImageBitmap(bitmap);
                    break;
            }
        }
    }

    private void processData(Response response) throws IOException, JSONException {
        mHandler.sendEmptyMessage(0);
        String jsonString = response.body().string();
        JSONObject jsonObject = new JSONObject(jsonString);
        String uid = jsonObject.getString("uid");//用户ID
        String encpass = jsonObject.getString("encpass");//有效加密验证串
    }

    private void processError(IOException e) {
        LogUtil.i(mContext, "报错" + e);
        Toast.makeText(mContext, "" + e, Toast.LENGTH_SHORT).show();
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
