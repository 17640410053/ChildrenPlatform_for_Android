package com.neusoft.yl.childrenplatform.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.neusoft.yl.childrenplatform.Bean.CommentBean;
import com.neusoft.yl.childrenplatform.Bean.OrderBean;
import com.neusoft.yl.childrenplatform.Const;
import com.neusoft.yl.childrenplatform.R;
import com.neusoft.yl.childrenplatform.ViewHolder.CommentViewHolder;
import com.neusoft.yl.childrenplatform.ViewHolder.OrderViewHolder;
import com.neusoft.yl.childrenplatform.ViewHolder.PartitionViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

public class OrderAdapter extends BaseAdapter {
    public OrderAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    RecyclerView.ViewHolder onCreateVH(ViewGroup parent, LayoutInflater layoutInflater, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.item_order_list, parent, false);
        OrderViewHolder viewHolder = new OrderViewHolder(itemView);
        return viewHolder;
    }

    @Override
    void onBindVH(RecyclerView.ViewHolder holder, List data, int position) {
        OrderBean orderBean = (OrderBean) data.get(position);
        if (holder instanceof OrderViewHolder) {
            OrderViewHolder viewHolder = (OrderViewHolder) holder;
            String url = Const.PIC_URL + "commodity_image/" + orderBean.getCommodity_image();
            viewHolder.commodity_name.setText(orderBean.getCommodity_name());
            viewHolder.order_num.setText("订单号：" + orderBean.getOrdernum());
            viewHolder.number.setText("数量：" + orderBean.getNumber());
            viewHolder.price.setText("总价：" + orderBean.getPrice());
            Picasso.with(context).load(url).into(viewHolder.commodity_image);
        }
    }
}
