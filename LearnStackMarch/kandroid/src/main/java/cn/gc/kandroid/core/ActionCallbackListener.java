package cn.gc.kandroid.core;

/**
 * Created by 宫成 on 16/3/29 上午11:20.
 */
public interface ActionCallbackListener<T> {
    void onSuccess(T data);

    void onFailure(String msg);
}
