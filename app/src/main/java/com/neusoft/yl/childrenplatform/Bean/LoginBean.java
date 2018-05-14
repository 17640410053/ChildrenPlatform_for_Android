package com.neusoft.yl.childrenplatform.Bean;

/**
 * Created by Kirito on 2017/11/25.
 */

public class LoginBean {

    /**
     * code : 200
     * message : 鐧诲綍鎴愬姛
     * data : {"infor_id":3,"user_id":3,"telephone":"17640410053","username":"用户_3","gender":3,"birthtime":"0000-00-00 00:00:00","address":"","email":"","image":"10.jpg","intro":""}
     */

    private String code;
    private String message;
    private DataBean data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * infor_id : 3
         * user_id : 3
         * telephone : 17640410053
         * username : 用户_3
         * gender : 3
         * birthtime : 0000-00-00 00:00:00
         * address :
         * email :
         * image : 10.jpg
         * intro :
         */

        private int infor_id;
        private String user_id;
        private String telephone;
        private String username;
        private int gender;
        private String birthtime;
        private String address;
        private String email;
        private String image;
        private String intro;

        public int getInfor_id() {
            return infor_id;
        }

        public void setInfor_id(int infor_id) {
            this.infor_id = infor_id;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public String getBirthtime() {
            return birthtime;
        }

        public void setBirthtime(String birthtime) {
            this.birthtime = birthtime;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }
    }
}
