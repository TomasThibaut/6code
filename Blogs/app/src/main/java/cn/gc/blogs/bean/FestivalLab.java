package cn.gc.blogs.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 宫成 on 16/2/15 上午10:38.
 */
public class FestivalLab {

    private List<Festival> mFestivalList = new ArrayList<>();

    public static FestivalLab mInstance;

    private List<Msg> msgs = new ArrayList<>();

    private FestivalLab() {
        mFestivalList.add(new Festival(1, "劳动节"));
        mFestivalList.add(new Festival(2, "中秋节"));
        mFestivalList.add(new Festival(3, "国庆节"));
        mFestivalList.add(new Festival(4, "端午节"));
        mFestivalList.add(new Festival(5, "七夕"));
        mFestivalList.add(new Festival(6, "圣诞"));
        mFestivalList.add(new Festival(7, "春节"));

        msgs.add(new Msg(1, 1, "what the fuck"));
        msgs.add(new Msg(2, 1, "what the fuck"));
        msgs.add(new Msg(3, 1, "what the fuck"));
        msgs.add(new Msg(4, 1, "what the fuck"));
        msgs.add(new Msg(5, 1, "what the fuck"));
        msgs.add(new Msg(6, 1, "what the fuck"));
        msgs.add(new Msg(7, 1, "what the fuck"));
    }

    public List<Msg> getMsgsByFestivalId(int fesId) {
        List<Msg> list = new ArrayList<>();
        for (Msg msg : msgs) {
            if (msg.getFestivalId() == fesId) {
                list.add(msg);
            }
        }
        return list;
    }

    public Msg getMsgById(int id) {
        for (Msg msg : msgs) {
            if (msg.getId() == id) {
                return msg;
            }
        }
        return null;
    }

    public List<Festival> getFestivals() {
        return new ArrayList<>(mFestivalList);
    }

    public static FestivalLab getInstance() {
        if (mInstance == null) {
            synchronized (FestivalLab.class) {
                if (mInstance == null) {
                    mInstance = new FestivalLab();
                }
            }
        }
        return mInstance;
    }

    public Festival getFestivalById(int fesId) {
        for (Festival festival : mFestivalList) {
            if (festival.getId() == fesId) {
                return festival;
            }
        }
        return null;
    }
}
