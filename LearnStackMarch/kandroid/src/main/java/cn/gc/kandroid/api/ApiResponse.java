package cn.gc.kandroid.api;

import java.util.List;

/**
 * Created by 宫成 on 16/3/29 上午10:52.
 */
public class ApiResponse<T> {

    public int event;
    public String msg;
    public int maxCount;
    public int maxPage;
    public int currentPage;
    public int pageSize;
    public T obj;
    public List<T> objList;


    public ApiResponse(int event, String msg) {
        this.event = event;
        this.msg = msg;
    }


    public boolean isSuccess() {
        return event == 0;
    }


    public int getMaxCount() {
        return maxCount;
    }


    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }


    public int getMaxPage() {
        return maxPage;
    }


    public void setMaxPage(int maxPage) {
        this.maxPage = maxPage;
    }


    public int getCurrentPage() {
        return currentPage;
    }


    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }


    public int getPageSize() {
        return pageSize;
    }


    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


    public int getEvent() {
        return event;
    }


    public void setEvent(int event) {
        this.event = event;
    }


    public String getMsg() {
        return msg;
    }


    public void setMsg(String msg) {
        this.msg = msg;
    }


    public T getObj() {
        return obj;
    }


    public void setObj(T obj) {
        this.obj = obj;
    }


    public List<T> getObjList() {
        return objList;
    }


    public void setObjList(List<T> objList) {
        this.objList = objList;
    }
}
