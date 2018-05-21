package com.neusoft.yl.childrenplatform.Bean;

public class OrderBean {

    /**
     * order_id : 65
     * ordernum : 2018051646746
     * user_id : 3
     * commodity_id : 15
     * number : 5
     * telephone : 17640410053
     * price : 100.00
     * ordertime : 2018-05-16 06:33:36
     * state : 6
     * commodity_name : 唐诗三百首
     * commodity_image : 59f82e6c37cb2.jpg
     */

    private int order_id;
    private String ordernum;
    private int user_id;
    private int commodity_id;
    private int number;
    private String telephone;
    private String price;
    private String ordertime;
    private int state;
    private String commodity_name;
    private String commodity_image;

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getCommodity_name() {
        return commodity_name;
    }

    public void setCommodity_name(String commodity_name) {
        this.commodity_name = commodity_name;
    }

    public String getCommodity_image() {
        return commodity_image;
    }

    public void setCommodity_image(String commodity_image) {
        this.commodity_image = commodity_image;
    }
}
