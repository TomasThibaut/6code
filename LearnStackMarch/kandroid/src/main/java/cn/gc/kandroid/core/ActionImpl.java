package cn.gc.kandroid.core;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import cn.gc.kandroid.api.Api;
import cn.gc.kandroid.api.ApiImpl;
import cn.gc.kandroid.api.ApiResponse;
import cn.gc.kandroid.core.utils.EncryptUtil;
import cn.gc.kandroid.model.CouponBO;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 宫成 on 16/3/29 上午11:21.
 */
public class ActionImpl implements Action {

    private Api mApi;


    public ActionImpl(Context context) {
        mApi = new ApiImpl(context);
    }


    @Override public void sendCode(final String phoneNum, final ActionCallbackListener l) {
        if (l == null) {
            throw new IllegalArgumentException("必须传递ApiCallbackListener对象");
        }
        //参数检查
        if (TextUtils.isEmpty(phoneNum)) {
            l.onFailure("手机号为空");
            return;
        }
        Pattern pattern = Pattern.compile(phoneNum);
        Matcher matcher = pattern.matcher("1\\d{10}");
        if (!matcher.matches()) {
            l.onFailure("手机号不正确");
            return;
        }

        //异步请求
        new AsyncTask<Void, Void, ApiResponse<Void>>() {
            @Override protected ApiResponse<Void> doInBackground(Void... params) {
                //分线程
                return mApi.sendCode(EncryptUtil.md5(phoneNum));
            }


            @Override protected void onPostExecute(ApiResponse<Void> response) {
                //UI线程
                if (response != null) {
                    if (response.isSuccess()) {
                        l.onSuccess(null);
                    }
                    else {
                        l.onFailure(response.getMsg());
                    }
                }
                else {
                    dealWithError(response);
                }
            }
        }.execute();
    }


    @Override
    public void register(final String phoneNum, final String pwd, final String code, final ActionCallbackListener l) {
        if (l == null) {
            throw new IllegalArgumentException("必须传递ApiCallbackListener对象");
        }
        //参数检查
        if (TextUtils.isEmpty(phoneNum) || TextUtils.isEmpty(pwd)) {
            l.onFailure("手机号或密码为空");
            return;
        }
        Pattern pattern = Pattern.compile(phoneNum);
        Matcher matcher = pattern.matcher("1\\d{10}");
        if (!matcher.matches()) {
            l.onFailure("手机号不正确");
            return;
        }

        new AsyncTask<Void, Void, ApiResponse<Void>>() {
            @Override protected ApiResponse<Void> doInBackground(Void... params) {
                return mApi.register(EncryptUtil.md5(phoneNum), code, pwd);
            }


            @Override protected void onPostExecute(ApiResponse<Void> response) {
                if (response != null) {
                    if (response.isSuccess()) {
                        l.onSuccess(null);
                    }
                    else {
                        l.onFailure(response.getMsg());
                    }
                }
                else {
                    dealWithError(response);
                }
            }
        }.execute();
    }


    @Override
    public void login(final String phoneNum, final String pwd, final ActionCallbackListener l) {
        //参数检查
        if (TextUtils.isEmpty(phoneNum) || TextUtils.isEmpty(pwd)) {
            l.onFailure("手机号或者密码不正确");
            return;
        }
        Pattern pattern = Pattern.compile(phoneNum);
        Matcher matcher = pattern.matcher("1\\d{10}");
        if (!matcher.matches()) {
            l.onFailure("手机号不正确");
            return;
        }

        new AsyncTask<Void, Void, ApiResponse<Void>>() {
            @Override protected ApiResponse<Void> doInBackground(Void... params) {
                return mApi.login(EncryptUtil.md5(phoneNum), pwd);
            }


            @Override protected void onPostExecute(ApiResponse<Void> response) {
                if (response != null) {
                    if (response.isSuccess()) {
                        l.onSuccess(null);
                    }
                    else {
                        l.onFailure(response.getMsg());
                    }
                }
                else {
                    dealWithError(response);
                }
            }
        }.execute();
    }


    @Override
    public void getCoupon(final int currentPage, final int pageSize, final ActionCallbackListener l) {
        //参数检查
        if (currentPage < 0 || pageSize < 0) {
            l.onFailure("分页参数不正确");
            return;
        }

        new AsyncTask<Void, Void, ApiResponse<CouponBO>>() {
            @Override protected ApiResponse<CouponBO> doInBackground(Void... params) {

                return mApi.getCouponList(currentPage, pageSize);
            }


            @Override protected void onPostExecute(ApiResponse<CouponBO> response) {
                if (response != null) {
                    if (response.isSuccess()) {
                        l.onSuccess(response);
                    }
                    else {
                        l.onFailure(response.getMsg());
                    }
                }
                else {
                    dealWithError(response);
                }
            }
        }.execute();
    }


    private void dealWithError(ApiResponse response) {
        // TODO: 16/3/30 异常处理机制

    }
}
