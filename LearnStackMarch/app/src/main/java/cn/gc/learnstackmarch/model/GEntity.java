package cn.gc.learnstackmarch.model;

import java.util.List;

/**
 * Created by 宫成 on 16/4/8 下午2:17.
 */
public class GEntity<T> {
    private List<String> category;
    private String error;
    private Result result;

    private class Result {
        private List<T> detial;
    }
}
