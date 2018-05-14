package com.neusoft.yl.childrenplatform.Model;

import com.neusoft.yl.childrenplatform.Const;
import com.neusoft.yl.childrenplatform.Listener.RetrofitListener;
import com.neusoft.yl.childrenplatform.Service.RetrofitService;

import retrofit2.Call;

/**
 * Created by Kirito on 2017/11/29.
 */

public class TypeModel extends RetrofitBaseModel {

    private RetrofitService retrofitService;

    public TypeModel(){
        this.retrofitService = retrofit.create(RetrofitService.class);
    }

    public void getTypeList(int id,RetrofitListener listener){
        Call call = retrofitService.getTypeList(id);
        bindCallback(call,listener, Const.GETTYPELIST);
    }
}
