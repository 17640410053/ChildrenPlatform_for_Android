package com.neusoft.yl.childrenplatform.Model;

import com.neusoft.yl.childrenplatform.Const;
import com.neusoft.yl.childrenplatform.Listener.RetrofitListener;
import com.neusoft.yl.childrenplatform.Service.RetrofitService;

import retrofit2.Call;

/**
 * Created by Kirito on 2017/11/27.
 */

public class CompModel extends RetrofitBaseModel {

    private RetrofitService retrofitService;

    public CompModel() {
        this.retrofitService = retrofit.create(RetrofitService.class);
    }

    public void getCompList(RetrofitListener listener) {
        Call call = retrofitService.getCompList();
        bindCallback(call, listener, Const.GETCOMPLIST);
    }

    public void getCommodityDetail(String commodity_id, RetrofitListener listener) {
        Call call = retrofitService.getCommodityDetail(commodity_id);
        bindCallback(call, listener, Const.GETCOMMODITYDETAIL);
    }

    public void getCommodityComment(String commodity_id, RetrofitListener listener) {
        Call call = retrofitService.getCommodityComment(commodity_id);
        bindCallback(call, listener, Const.GETCOMMODITYCOMMENT);
    }

    public void getCommodityIntro(String commodity_id, RetrofitListener listener) {
        Call call = retrofitService.getCommodityIntro(commodity_id);
        bindCallback(call, listener, Const.GETCOMMODITYINTRO);
    }

    public void getIsCollect(String commodity_id, String user_id, RetrofitListener listener) {
        Call call = retrofitService.getIsCollect(commodity_id, user_id);
        bindCallback(call, listener, Const.ISCOLLECT);
    }

    public void getCollect(String commodity_id, String user_id, RetrofitListener listener) {
        Call call = retrofitService.getCollect(commodity_id, user_id);
        bindCallback(call, listener, Const.COLLECT);
    }

    public void getIsFollow(int company_id, String user_id, RetrofitListener listener) {
        Call call = retrofitService.getIsFollow(company_id, user_id);
        bindCallback(call, listener, Const.ISFOLLOW);
    }

    public void getFollow(int company_id, String user_id, RetrofitListener listener) {
        Call call = retrofitService.getFollow(company_id, user_id);
        bindCallback(call, listener, Const.FOLLOW);
    }

    public void upOrder(String commodity_id, String user_id, String address, String telephone, String number, RetrofitListener listener) {
        Call call = retrofitService.upOrder(commodity_id,user_id,telephone,address,number);
        bindCallback(call,listener,Const.UPORDER);
    }

    public void getCompPartition(int id,RetrofitListener listener){
        Call call = retrofitService.getCompPartition(id);
        bindCallback(call,listener,Const.GETCOMPPARTITION);
    }
}
