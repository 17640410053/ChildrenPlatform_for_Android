package com.neusoft.yl.childrenplatform.Model;

import com.neusoft.yl.childrenplatform.Const;
import com.neusoft.yl.childrenplatform.Listener.RetrofitListener;
import com.neusoft.yl.childrenplatform.Service.RetrofitService;

import retrofit2.Call;

public class TrendsModel extends RetrofitBaseModel{
    private RetrofitService retrofitService;

    public TrendsModel(){
        this.retrofitService = retrofit.create(RetrofitService.class);
    }

    public void getTrends(RetrofitListener listener){
        Call call = retrofitService.getTrends();
        bindCallback(call,listener, Const.GETTRENDS);
    }
}
