package com.neusoft.yl.childrenplatform.Bean;

public class CommentBean {

    /**
     * comment_id : 4
     * user_id : 3
     * commodity_id : 15
     * details : 这本书很不错，推荐！！！
     * datetime : 2018-04-18 21:12:45
     * image :
     * username : adsad
     * user_image : 10.jpg
     */

    private int comment_id;
    private int user_id;
    private int commodity_id;
    private String details;
    private String datetime;
    private String image;
    private String username;
    private String user_image;

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCommodity_id() {
        return commodity_id;
    }

    public void setCommodity_id(int commodity_id) {
        this.commodity_id = commodity_id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUser_image() {
        return user_image;
    }

    public void setUser_image(String user_image) {
        this.user_image = user_image;
    }
}
