package com.neusoft.yl.childrenplatform.Bean;

/**
 * Created by Kirito on 2017/11/28.
 */

public class RegisterBean {

    /**
     * code : 404
     * message : 手机号已经存在
     * data : fail
     */

    private String code;
    private String message;
    private String data;

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getData() {
        return data;
    }
}
