package com.neusoft.yl.childrenplatform.Model;

import com.neusoft.yl.childrenplatform.Const;
import com.neusoft.yl.childrenplatform.Listener.RetrofitListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Kirito on 2017/11/25.
 */

public abstract class RetrofitBaseModel {
    protected Retrofit retrofit;
    public RetrofitBaseModel(){
        retrofit = new Retrofit.Builder().baseUrl(Const.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
    }

    public <T> void bindCallback(Call<T> call, final RetrofitListener<T> listener, final int flag){
        Callback<T> callback = new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                listener.onSuccess(response.body(),flag);
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                listener.onFail();
            }
        };
        call.enqueue(callback);
    }
}
