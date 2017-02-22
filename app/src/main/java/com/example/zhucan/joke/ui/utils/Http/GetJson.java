package com.example.zhucan.joke.ui.utils.Http;

/**
 * Created by zhucan on 2017/2/19.
 */

public class GetJson {


        private String username;
        private String createTime;
        private String content;
        private String iconUrl;

        public String getIconUrl() {
            return iconUrl;
        }

        public void setIconUrl(String iconUrl) {
            this.iconUrl = iconUrl;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public int getPraiseCount() {

            return praiseCount;
        }

        public void setPraiseCount(int praiseCount) {
            this.praiseCount = praiseCount;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Message{" +
                    "username='" + username + '\'' +
                    ", createTime='" + createTime + '\'' +
                    ", content='" + content + '\'' +
                    ", iconUrl='" + iconUrl + '\'' +
                    ", id=" + id +
                    ", praiseCount=" + praiseCount +
                    ", commentCount=" + commentCount +
                    '}';
        }

        public String getContent() {
            return content;

        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreateTime() {
            return createTime;

        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        private int id;
        private int praiseCount;
        private int commentCount;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }

