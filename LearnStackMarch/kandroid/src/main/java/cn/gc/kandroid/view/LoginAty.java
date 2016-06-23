package cn.gc.kandroid.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.gc.kandroid.R;
import cn.gc.kandroid.core.ActionCallbackListener;

/**
 * Created by 宫成 on 16/3/29 上午10:34.
 */
public class LoginAty extends BaseAty {

    @Bind(R.id.btn_login) Button loginBtn;
    @Bind(R.id.edit_phone) EditText phoneEdit;
    @Bind(R.id.edit_password) EditText pwdEdit;


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.btn_login) void onBtnClick() {

        String phoneNum = phoneEdit.getText().toString().trim();
        String pwd = pwdEdit.getText().toString().trim();

        mAction.login(phoneNum, pwd, new ActionCallbackListener() {
            @Override public void onSuccess(Object data) {
                startActivity(new Intent(mContext, CouponAty.class));
                finish();
            }


            @Override public void onFailure(String msg) {
                Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                startActivity(new Intent(this, RegisterAty.class));
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
