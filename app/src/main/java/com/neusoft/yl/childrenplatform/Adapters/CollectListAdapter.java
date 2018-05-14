package com.neusoft.yl.childrenplatform.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.neusoft.yl.childrenplatform.Activity.CommodityDetailActivity;
import com.neusoft.yl.childrenplatform.Bean.CollectBean;
import com.neusoft.yl.childrenplatform.Const;
import com.neusoft.yl.childrenplatform.R;
import com.neusoft.yl.childrenplatform.ViewHolder.CollectViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Kirito on 2017/12/2.
 */

public class CollectListAdapter extends BaseAdapter {
    public CollectListAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    RecyclerView.ViewHolder onCreateVH(ViewGroup parent, LayoutInflater layoutInflater, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.item_collect_list, parent, false);
        CollectViewHolder viewHolder = new CollectViewHolder(itemView);
        return viewHolder;
    }

    @Override
    void onBindVH(RecyclerView.ViewHolder holder, List data, int position) {
        final CollectBean collectBean = (CollectBean) data.get(position);
        if (holder instanceof CollectViewHolder) {
            CollectViewHolder viewHolder = (CollectViewHolder) holder;
            String url = Const.PIC_URL + "commodity_image/" + collectBean.getMiddle_pic();
            viewHolder.collect_name.setText(collectBean.getName());
            viewHolder.hint_num.setText(collectBean.getHintnum());
            viewHolder.comment_num.setText(collectBean.getComment());
            Picasso.with(context).load(url).into(viewHolder.collect_pic);
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context,CommodityDetailActivity.class);
                    intent.putExtra("commodity_id",collectBean.getCommodity_id());
                    context.startActivity(intent);
                }
            });
        }
    }
}
