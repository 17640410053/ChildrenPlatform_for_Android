package com.neusoft.yl.childrenplatform.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.neusoft.yl.childrenplatform.Activity.CommodityDetailActivity;
import com.neusoft.yl.childrenplatform.Bean.TrendsBean;
import com.neusoft.yl.childrenplatform.Const;
import com.neusoft.yl.childrenplatform.R;
import com.neusoft.yl.childrenplatform.ViewHolder.TrendsViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TrendsAdapter extends BaseAdapter {
    public TrendsAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    RecyclerView.ViewHolder onCreateVH(ViewGroup parent, LayoutInflater layoutInflater, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.item_trends_list, parent, false);
        TrendsViewHolder viewHolder = new TrendsViewHolder(itemView);
        return viewHolder;
    }

    @Override
    void onBindVH(RecyclerView.ViewHolder holder, List data, int position) {
        final TrendsBean trendsBean = (TrendsBean) data.get(position);
        if (holder instanceof TrendsViewHolder){
            TrendsViewHolder viewHolder = (TrendsViewHolder) holder;
            viewHolder.commodity_browse_num.setText(trendsBean.getHintnum()+"浏览");
            viewHolder.commodity_date.setText(trendsBean.getCreatetime());
            if (trendsBean.getIntro().equals("")){
                viewHolder.commodity_intro.setText("此商品尚未填写简介");
            }else {
                viewHolder.commodity_intro.setText(trendsBean.getIntro());
            }
            viewHolder.commodity_name.setText(trendsBean.getName());
            viewHolder.company_name.setText(trendsBean.getCompany_name());
            String company_url = Const.PIC_URL + "company_image/" + trendsBean.getCompany_image();
            Picasso.with(context).load(company_url).into(viewHolder.company_image);
            String commodity_url = Const.PIC_URL + "commodity_image/" + trendsBean.getMiddle_pic();
            Picasso.with(context).load(commodity_url).into(viewHolder.commodity_image);
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context,CommodityDetailActivity.class);
                    intent.putExtra("commodity_id",trendsBean.getCommodity_id());
                    context.startActivity(intent);
                }
            });
        }
    }
}
