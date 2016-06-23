package cn.gc.kandroid.api;

import cn.gc.kandroid.model.CouponBO;

/**
 * Created by 宫成 on 16/3/29 上午10:46.
 */
public interface Api {
    ApiResponse<Void> sendCode(String phoneNum);

    ApiResponse<Void> login(String phoneNum, String pwd);

    ApiResponse<Void> register(String phoneNum, String code, String pwd);

    ApiResponse<CouponBO> getCouponList(int currentPage, int pageSize);
}
