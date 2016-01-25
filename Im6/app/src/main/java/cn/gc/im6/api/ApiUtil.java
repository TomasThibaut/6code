package cn.gc.im6.api;

/**
 * Created by 宫成 on 16/1/21 下午11:31.
 */
public class ApiUtil {
    public static String BASE_URL = "http://dev.huanpeng.com";

    /**
     * 07 获取预置游戏列表：http://dev.huanpeng.com/a/getGList.php
     */
    public static String getGList() {
        return BASE_URL + "/a/getGList.php";
    }

    /**
     * 08 获取游戏类型列表：http://dev.huanpeng.com/a/getGTList.php
     */
    public static String getGTList() {
        return BASE_URL + "/a/getGTList.php";
    }
}
