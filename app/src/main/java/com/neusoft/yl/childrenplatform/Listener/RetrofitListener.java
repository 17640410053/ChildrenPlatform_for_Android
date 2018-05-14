package com.neusoft.yl.childrenplatform.Listener;

import android.view.View;

/**
 * Created by Kirito on 2017/11/25.
 */

public interface RetrofitListener<T> {
    void initView();

    void onClick(View view);

    void initData();

    public void onSuccess(T t,int flag);
    public void onFail();
}
