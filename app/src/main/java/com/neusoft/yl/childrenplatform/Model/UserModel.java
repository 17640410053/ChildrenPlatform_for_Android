package com.neusoft.yl.childrenplatform.Model;

import com.neusoft.yl.childrenplatform.Const;
import com.neusoft.yl.childrenplatform.Listener.RetrofitListener;
import com.neusoft.yl.childrenplatform.Service.RetrofitService;

import retrofit2.Call;

/**
 * Created by Kirito on 2017/11/25.
 */

public class UserModel extends RetrofitBaseModel {
    private RetrofitService userService;
    private int flag;

    public UserModel(){
        this.userService = retrofit.create(RetrofitService.class);
    }


    //用户登录
    public void userLogin(String telephone, String password, RetrofitListener listener){
        Call call = userService.userLogin(telephone,password);
        this.flag = Const.USERLOGIN;
        bindCallback(call,listener, Const.USERLOGIN);
    }

    //用户注册
    public void userRegister(String telephone,String password,RetrofitListener listener){
        Call call = userService.userRegister(telephone,password);
        this.flag = Const.USERREGISTER;
        bindCallback(call,listener,Const.USERREGISTER);

    }

    //获取用户中心信息
    public void userInformation(String id,RetrofitListener listener){
        Call call = userService.getUserInformation(id);
        this.flag = Const.GETUSERINFORMATION;
        bindCallback(call,listener,Const.GETUSERINFORMATION);
    }

    //修改用户昵称
    public void updateUsername(String id,String username,RetrofitListener listener){
        Call call = userService.upUsername(id,username);
        this.flag = Const.UPUSERNAME;
        bindCallback(call,listener,Const.UPUSERNAME);
    }

    //修改用户个性签名
    public void updateUserintro(String id,String intro,RetrofitListener listener){
        Call call = userService.upUserintro(id,intro);
        this.flag = Const.UPUSERINTRO;
        bindCallback(call,listener,Const.UPUSERINTRO);
    }

    //修改用户性别接口
    public void updateUserSex(String id,String sex,RetrofitListener listener){
        Call call = userService.upUsersex(id,sex);
        this.flag = Const.UPUSERSEX;
        bindCallback(call,listener,Const.UPUSERSEX);
    }

    //获取用户收藏信息接口
    public void getUuserCollect(String id,RetrofitListener listener){
        Call call = userService.getUserCollect(id);
        this.flag = Const.GETUSERCOLLECT;
        bindCallback(call,listener,Const.GETUSERCOLLECT);
    }

    public void getUserOrder(String user_id,RetrofitListener listener){
        Call call = userService.getUserOrder(user_id);
        this.flag = Const.GETUSERORDER;
        bindCallback(call ,listener,Const.GETUSERORDER);
    }
}
