package cn.gc.kandroid.core;

/**
 * Created by 宫成 on 16/3/29 上午11:19.
 */
public interface Action {
    void sendCode(String phoneNum, ActionCallbackListener l);

    void register(String phoneNum, String pwd, String code, ActionCallbackListener l);

    void login(String phoneNum, String pwd, ActionCallbackListener l);

    void getCoupon(int currentPage, int pageSize, ActionCallbackListener l);
}
