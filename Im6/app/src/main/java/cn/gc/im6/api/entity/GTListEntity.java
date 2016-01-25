package cn.gc.im6.api.entity;

import java.util.List;

/**
 * Created by 宫成 on 16/1/22 上午9:35.
 */
public class GTListEntity {

    /**
     * gameTypeList : [{"gameTypeID":"2","gameTypeName":"网络游戏","gameIconURL":"http://dev-img.huanpeng.com/gimg/game_type_icon_0.png","gameCount":"5","liveCount":"3","videoCount":"17"},{"gameTypeID":"8","gameTypeName":"跑酷竞速","gameIconURL":"http://dev-img.huanpeng.com/gimg/game_type_icon_1.png","gameCount":"4","liveCount":"1","videoCount":"11"},{"gameTypeID":"14","gameTypeName":"卡牌对战","gameIconURL":"http://dev-img.huanpeng.com/gimg/game_type_icon_2.png","gameCount":"3","liveCount":"5","videoCount":"23"},{"gameTypeID":"20","gameTypeName":"飞行射击","gameIconURL":"http://dev-img.huanpeng.com/gimg/game_type_icon_3.png","gameCount":"2","liveCount":"0","videoCount":"1"},{"gameTypeID":"26","gameTypeName":"塔防策略","gameIconURL":"http://dev-img.huanpeng.com/gimg/game_type_icon_4.png","gameCount":"2","liveCount":"0","videoCount":"1"},{"gameTypeID":"32","gameTypeName":"休闲棋牌","gameIconURL":"http://dev-img.huanpeng.com/gimg/game_type_icon_5.png","gameCount":"3","liveCount":"1","videoCount":"4"},{"gameTypeID":"38","gameTypeName":"体育格斗","gameIconURL":"http://dev-img.huanpeng.com/gimg/game_type_icon_6.png","gameCount":"2","liveCount":"1","videoCount":"7"},{"gameTypeID":"44","gameTypeName":"其他","gameIconURL":"http://dev-img.huanpeng.com/gimg/game_type_icon_7.png","gameCount":"0","liveCount":"0","videoCount":"3"}]
     * all : {"gameTypeID":0,"gameTypeName":"全部直播","gameIconURL":"http://dev-img.huanpeng.com/gimg/game_type_icon_0.png","liveCount":"","videoCount":""}
     */

    private AllEntity all;
    private List<GameTypeListEntity> gameTypeList;

    public void setAll(AllEntity all) {
        this.all = all;
    }

    public void setGameTypeList(List<GameTypeListEntity> gameTypeList) {
        this.gameTypeList = gameTypeList;
    }

    public AllEntity getAll() {
        return all;
    }

    public List<GameTypeListEntity> getGameTypeList() {
        return gameTypeList;
    }

    public static class AllEntity {
        /**
         * gameTypeID : 0
         * gameTypeName : 全部直播
         * gameIconURL : http://dev-img.huanpeng.com/gimg/game_type_icon_0.png
         * liveCount :
         * videoCount :
         */

        private int gameTypeID;
        private String gameTypeName;
        private String gameIconURL;
        private String liveCount;
        private String videoCount;

        public void setGameTypeID(int gameTypeID) {
            this.gameTypeID = gameTypeID;
        }

        public void setGameTypeName(String gameTypeName) {
            this.gameTypeName = gameTypeName;
        }

        public void setGameIconURL(String gameIconURL) {
            this.gameIconURL = gameIconURL;
        }

        public void setLiveCount(String liveCount) {
            this.liveCount = liveCount;
        }

        public void setVideoCount(String videoCount) {
            this.videoCount = videoCount;
        }

        public int getGameTypeID() {
            return gameTypeID;
        }

        public String getGameTypeName() {
            return gameTypeName;
        }

        public String getGameIconURL() {
            return gameIconURL;
        }

        public String getLiveCount() {
            return liveCount;
        }

        public String getVideoCount() {
            return videoCount;
        }
    }

    public static class GameTypeListEntity {
        /**
         * gameTypeID : 2
         * gameTypeName : 网络游戏
         * gameIconURL : http://dev-img.huanpeng.com/gimg/game_type_icon_0.png
         * gameCount : 5
         * liveCount : 3
         * videoCount : 17
         */

        private String gameTypeID;
        private String gameTypeName;
        private String gameIconURL;
        private String gameCount;
        private String liveCount;
        private String videoCount;

        public void setGameTypeID(String gameTypeID) {
            this.gameTypeID = gameTypeID;
        }

        public void setGameTypeName(String gameTypeName) {
            this.gameTypeName = gameTypeName;
        }

        public void setGameIconURL(String gameIconURL) {
            this.gameIconURL = gameIconURL;
        }

        public void setGameCount(String gameCount) {
            this.gameCount = gameCount;
        }

        public void setLiveCount(String liveCount) {
            this.liveCount = liveCount;
        }

        public void setVideoCount(String videoCount) {
            this.videoCount = videoCount;
        }

        public String getGameTypeID() {
            return gameTypeID;
        }

        public String getGameTypeName() {
            return gameTypeName;
        }

        public String getGameIconURL() {
            return gameIconURL;
        }

        public String getGameCount() {
            return gameCount;
        }

        public String getLiveCount() {
            return liveCount;
        }

        public String getVideoCount() {
            return videoCount;
        }
    }
}
