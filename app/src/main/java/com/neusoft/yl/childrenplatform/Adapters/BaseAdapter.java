package com.neusoft.yl.childrenplatform.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Kirito on 2017/11/27.
 */

public abstract class BaseAdapter extends RecyclerView.Adapter {
    protected Context context;
    protected List data;
    protected LayoutInflater layoutInflater;

    public BaseAdapter(Context context, List data){
        this.context = context;
        this.data = data;
        layoutInflater = LayoutInflater.from(context);
    }

    abstract RecyclerView.ViewHolder onCreateVH(ViewGroup parent,LayoutInflater layoutInflater ,int viewType);
    abstract void onBindVH(RecyclerView.ViewHolder holder, List data, int position);

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return onCreateVH(parent,layoutInflater, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        onBindVH(holder,data,position);
    }

    @Override
    public int getItemCount() {
        if (data != null){
            return data.size();
        }else {
            return 0;
        }
    }
}
