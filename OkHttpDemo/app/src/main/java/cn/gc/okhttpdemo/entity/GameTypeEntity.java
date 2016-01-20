package cn.gc.okhttpdemo.entity;

import java.util.List;

/**
 * Created by 宫成 on 16/1/19 下午1:46.
 *
 */
public class GameTypeEntity {

    /**
     * gameTypeList : [{"videoCount":"17","gameTypeID":"2","liveCount":"3","gameIconURL":"http://dev-img.huanpeng.com/gimg/game_type_icon_0.png","gameCount":"5","gameTypeName":"网络游戏"},{"videoCount":"11","gameTypeID":"8","liveCount":"1","gameIconURL":"http://dev-img.huanpeng.com/gimg/game_type_icon_1.png","gameCount":"4","gameTypeName":"跑酷竞速"},{"videoCount":"23","gameTypeID":"14","liveCount":"5","gameIconURL":"http://dev-img.huanpeng.com/gimg/game_type_icon_2.png","gameCount":"3","gameTypeName":"卡牌对战"},{"videoCount":"1","gameTypeID":"20","liveCount":"0","gameIconURL":"http://dev-img.huanpeng.com/gimg/game_type_icon_3.png","gameCount":"2","gameTypeName":"飞行射击"},{"videoCount":"1","gameTypeID":"26","liveCount":"0","gameIconURL":"http://dev-img.huanpeng.com/gimg/game_type_icon_4.png","gameCount":"2","gameTypeName":"塔防策略"},{"videoCount":"4","gameTypeID":"32","liveCount":"1","gameIconURL":"http://dev-img.huanpeng.com/gimg/game_type_icon_5.png","gameCount":"3","gameTypeName":"休闲棋牌"},{"videoCount":"7","gameTypeID":"38","liveCount":"1","gameIconURL":"http://dev-img.huanpeng.com/gimg/game_type_icon_6.png","gameCount":"2","gameTypeName":"体育格斗"},{"videoCount":"3","gameTypeID":"44","liveCount":"0","gameIconURL":"http://dev-img.huanpeng.com/gimg/game_type_icon_7.png","gameCount":"0","gameTypeName":"其他"}]
     */

    private List<GameTypeListEntity> gameTypeList;

    public void setGameTypeList(List<GameTypeListEntity> gameTypeList) {
        this.gameTypeList = gameTypeList;
    }

    public List<GameTypeListEntity> getGameTypeList() {
        return gameTypeList;
    }

    public static class GameTypeListEntity {
        /**
         * videoCount : 17
         * gameTypeID : 2
         * liveCount : 3
         * gameIconURL : http://dev-img.huanpeng.com/gimg/game_type_icon_0.png
         * gameCount : 5
         * gameTypeName : 网络游戏
         */

        private String videoCount;
        private String gameTypeID;
        private String liveCount;
        private String gameIconURL;
        private String gameCount;
        private String gameTypeName;

        public void setVideoCount(String videoCount) {
            this.videoCount = videoCount;
        }

        public void setGameTypeID(String gameTypeID) {
            this.gameTypeID = gameTypeID;
        }

        public void setLiveCount(String liveCount) {
            this.liveCount = liveCount;
        }

        public void setGameIconURL(String gameIconURL) {
            this.gameIconURL = gameIconURL;
        }

        public void setGameCount(String gameCount) {
            this.gameCount = gameCount;
        }

        public void setGameTypeName(String gameTypeName) {
            this.gameTypeName = gameTypeName;
        }

        public String getVideoCount() {
            return videoCount;
        }

        public String getGameTypeID() {
            return gameTypeID;
        }

        public String getLiveCount() {
            return liveCount;
        }

        public String getGameIconURL() {
            return gameIconURL;
        }

        public String getGameCount() {
            return gameCount;
        }

        public String getGameTypeName() {
            return gameTypeName;
        }
    }
}
