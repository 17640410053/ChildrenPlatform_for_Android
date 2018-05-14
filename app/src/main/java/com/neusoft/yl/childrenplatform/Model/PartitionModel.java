package com.neusoft.yl.childrenplatform.Model;

import com.neusoft.yl.childrenplatform.Const;
import com.neusoft.yl.childrenplatform.Listener.RetrofitListener;
import com.neusoft.yl.childrenplatform.Service.RetrofitService;

import retrofit2.Call;

public class PartitionModel extends RetrofitBaseModel {
    private RetrofitService retrofitService;

    public PartitionModel(){
        this.retrofitService = retrofit.create(RetrofitService.class);
    }

    public void getPartition(RetrofitListener listener){
        Call call = retrofitService.getPartition();
        bindCallback(call,listener, Const.GETPARTITION);
    }
}
