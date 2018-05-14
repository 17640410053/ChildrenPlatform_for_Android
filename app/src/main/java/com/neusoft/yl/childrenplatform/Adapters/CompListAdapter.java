package com.neusoft.yl.childrenplatform.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.neusoft.yl.childrenplatform.Activity.CommodityDetailActivity;
import com.neusoft.yl.childrenplatform.Bean.CompBean;
import com.neusoft.yl.childrenplatform.Const;
import com.neusoft.yl.childrenplatform.R;
import com.neusoft.yl.childrenplatform.ViewHolder.CompViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Kirito on 2017/11/27.
 */

public class CompListAdapter extends BaseAdapter {
    public CompListAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    RecyclerView.ViewHolder onCreateVH(ViewGroup parent, LayoutInflater layoutInflater, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.item_comp_list,parent,false);
        CompViewHolder viewHolder = new CompViewHolder(itemView);
        return viewHolder;
    }

    @Override
    void onBindVH(RecyclerView.ViewHolder holder, List data, int position) {
        final CompBean compBean = (CompBean) data.get(position);
        if (holder instanceof CompViewHolder){
            final CompViewHolder viewHolder = (CompViewHolder) holder;
            String url = Const.PIC_URL + "commodity_image/" + compBean.getMiddle_pic();
            viewHolder.text_browse.setText(compBean.getHintnum());
            viewHolder.text_comment.setText(compBean.getCollectnum());
            viewHolder.text_name.setText(compBean.getName());
            viewHolder.text_type.setText(compBean.getType());
            viewHolder.text_child_type.setText(compBean.getChild_type());
            Picasso.with(context).load(url).into(viewHolder.comp_img);

            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context,CommodityDetailActivity.class);
                    intent.putExtra("commodity_id",compBean.getCommodity_id());
                    context.startActivity(intent);
                }
            });
        }
    }
}
