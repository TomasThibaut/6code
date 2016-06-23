package cn.gc.kandroid.api;

import android.content.Context;
import cn.gc.kandroid.KApplication;
import cn.gc.kandroid.api.utils.HttpEngine;
import cn.gc.kandroid.model.CouponBO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 宫成 on 16/3/29 上午11:08.
 */
public class ApiImpl implements Api {
    private static final String TIME_OUT_MSG = "连接服务器失败";
    public static final int TIME_OUT = 20000;
    public static final String URL = "http://uat.b.quancome.com/platform/api";
    public static final String appKey = "ANDROID_KCOUPON";
    public static final String registerMethod = "customer.loginByApp";
    public static final String sendCodeMethod = "ANDROID_KCOUPON";
    public static final String loginMethod = "customer.loginByApp";
    public static final String couponMethod = "issue.listNewCoupon";
    private static final String loginOS = "1";
    HttpEngine mEngine;
    Gson mGson;
    String imei;


    public ApiImpl(Context context) {
        mEngine = HttpEngine.getInstance();
        mGson = new Gson();
        imei = ((KApplication) context.getApplicationContext()).getImei();
    }


    @Override public ApiResponse<Void> sendCode(String phoneNum) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("phoneNum", phoneNum);
        paramMap.put("appKey", appKey);
        paramMap.put("method", sendCodeMethod);
        Type type = new TypeToken<ApiResponse<Void>>() {}.getType();
        ApiResponse<Void> response = mEngine.postHandle(paramMap, type);
        if (response != null) {
            return response;
        }
        else {
            return new ApiResponse<>(-1, TIME_OUT_MSG);
        }
    }


    @Override public ApiResponse<Void> login(String phoneNum, String pwd) {

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("loginName", phoneNum);
        paramMap.put("appKey", appKey);
        paramMap.put("password", pwd);
        paramMap.put("imei", imei);
        paramMap.put("loginOS", loginOS);
        paramMap.put("method", loginMethod);
        Type type = new TypeToken<ApiResponse<Void>>() {}.getType();
        ApiResponse<Void> response = mEngine.postHandle(paramMap, type);
        if (response != null) {
            return response;
        }
        else {
            return new ApiResponse<>(-1, TIME_OUT_MSG);
        }
    }


    @Override public ApiResponse<Void> register(String phoneNum, String code, String pwd) {

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("phoneNum", phoneNum);
        paramMap.put("code", code);
        paramMap.put("password", pwd);
        paramMap.put("appKey", appKey);
        paramMap.put("method", registerMethod);

        Type type = new TypeToken<ApiResponse<Void>>() {}.getType();
        ApiResponse<Void> response = mEngine.postHandle(paramMap, type);
        if (response == null) {
            return new ApiResponse<>(-1, TIME_OUT_MSG);
        }
        else {
            return response;
        }
    }


    @Override public ApiResponse<CouponBO> getCouponList(int currentPage, int pageSize) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("appKey", appKey);
        paramMap.put("method", registerMethod);
        paramMap.put("currentPage", String.valueOf(currentPage));
        paramMap.put("pageSize", String.valueOf(pageSize));

        Type type = new TypeToken<ApiResponse<CouponBO>>() {}.getType();
        ApiResponse<CouponBO> response = mEngine.postHandle(paramMap, type);
        if (response == null) {
            return new ApiResponse<>(-1, TIME_OUT_MSG);
        }
        else {
            return response;
        }
    }
}
