package cn.gc.kandroid.view;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.gc.kandroid.R;
import cn.gc.kandroid.core.ActionCallbackListener;

/**
 * Created by 宫成 on 16/3/29 上午10:42.
 */
public class RegisterAty extends BaseAty {

    @Bind(R.id.edit_phone_register) EditText phoneEdit;
    @Bind(R.id.edit_code_register) EditText codeEdit;
    @Bind(R.id.edit_pwd_register) EditText pwdEdit;


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBar.setLogo(R.mipmap.ic_launcher);
    }


    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_register, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @OnClick(R.id.btn_send_code) void onSendCode() {
        String phoneNum = phoneEdit.getText().toString().trim();

        mAction.sendCode(phoneNum, new ActionCallbackListener() {
            @Override public void onSuccess(Object data) {
                Toast.makeText(mContext, "验证码发送成功~请注意查收~", Toast.LENGTH_SHORT).show();
            }


            @Override public void onFailure(String msg) {
                Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }


    @OnClick(R.id.btn_register) void onRegister() {
        String phoneNum = phoneEdit.getText().toString().trim();
        String code = codeEdit.getText().toString().trim();
        String pwd = pwdEdit.getText().toString().trim();

        mAction.register(phoneNum, code, pwd, new ActionCallbackListener() {
            @Override public void onSuccess(Object data) {
                Toast.makeText(mContext, "注册成功!请登录~", Toast.LENGTH_SHORT).show();
                finish();
            }


            @Override public void onFailure(String msg) {
                Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
