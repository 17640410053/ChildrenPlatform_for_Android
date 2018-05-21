package com.neusoft.yl.childrenplatform.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.neusoft.yl.childrenplatform.R;


public class OrderViewHolder extends RecyclerView.ViewHolder {
    public TextView order_num,commodity_name,number,price;
    public ImageView commodity_image;
    public View itemView;

    public OrderViewHolder(View itemView) {
        super(itemView);

        this.itemView = itemView;
        order_num = itemView.findViewById(R.id.order_num);
        commodity_name = itemView.findViewById(R.id.commodity_name);
        number = itemView.findViewById(R.id.number);
        price = itemView.findViewById(R.id.price);
        commodity_image = itemView.findViewById(R.id.commodity_image);

    }
}
