package cn.gc.im6.api.entity;

import java.util.List;

/**
 * Created by 宫成 on 16/1/21 下午11:58.
 */
public class GListEntity {


    /**
     * gameList : [{"gameID":"2","gameName":"梦幻西游","videoCount":"4","gameTypeID":"2","iconURL":"http://dev-img.huanpeng.com/gimg/game_icon_0.png","followCount":"6","liveCount":"2","posterURL":"http://dev-img.huanpeng.com/gimg/game_icon_background_0.png"},{"gameID":"8","gameName":"炉石传说","videoCount":"21","gameTypeID":"14","iconURL":"http://dev-img.huanpeng.com/gimg/game_icon_1.png","followCount":"5","liveCount":"5","posterURL":"http://dev-img.huanpeng.com/gimg/game_icon_background_1.png"}]
     */

    private List<GameListEntity> gameList;

    public void setGameList(List<GameListEntity> gameList) {
        this.gameList = gameList;
    }

    public List<GameListEntity> getGameList() {
        return gameList;
    }

    public static class GameListEntity {
        /**
         * gameID : 2
         * gameName : 梦幻西游
         * videoCount : 4
         * gameTypeID : 2
         * iconURL : http://dev-img.huanpeng.com/gimg/game_icon_0.png
         * followCount : 6
         * liveCount : 2
         * posterURL : http://dev-img.huanpeng.com/gimg/game_icon_background_0.png
         */

        private String gameID;
        private String gameName;
        private String videoCount;
        private String gameTypeID;
        private String iconURL;
        private String followCount;
        private String liveCount;
        private String posterURL;


        public void setGameID(String gameID) {
            this.gameID = gameID;
        }

        public void setGameName(String gameName) {
            this.gameName = gameName;
        }

        public void setVideoCount(String videoCount) {
            this.videoCount = videoCount;
        }

        public void setGameTypeID(String gameTypeID) {
            this.gameTypeID = gameTypeID;
        }

        public void setIconURL(String iconURL) {
            this.iconURL = iconURL;
        }

        public void setFollowCount(String followCount) {
            this.followCount = followCount;
        }

        public void setLiveCount(String liveCount) {
            this.liveCount = liveCount;
        }

        public void setPosterURL(String posterURL) {
            this.posterURL = posterURL;
        }

        public String getGameID() {
            return gameID;
        }

        public String getGameName() {
            return gameName;
        }

        public String getVideoCount() {
            return videoCount;
        }

        public String getGameTypeID() {
            return gameTypeID;
        }

        public String getIconURL() {
            return iconURL;
        }

        public String getFollowCount() {
            return followCount;
        }

        public String getLiveCount() {
            return liveCount;
        }

        public String getPosterURL() {
            return posterURL;
        }
    }
}
