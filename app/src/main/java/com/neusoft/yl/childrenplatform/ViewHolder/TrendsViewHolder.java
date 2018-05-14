package com.neusoft.yl.childrenplatform.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.neusoft.yl.childrenplatform.R;

public class TrendsViewHolder extends RecyclerView.ViewHolder {
    public TextView company_name,commodity_date,commodity_intro,commodity_name,commodity_browse_num;
    public RoundedImageView company_image,commodity_image;


    public View itemView;
    public TrendsViewHolder(View itemView) {
        super(itemView);

        this.itemView = itemView;
        company_name = itemView.findViewById(R.id.company_name);
        commodity_date = itemView.findViewById(R.id.commodity_date);
        commodity_intro = itemView.findViewById(R.id.commodity_intro);
        commodity_name = itemView.findViewById(R.id.commodity_name);
        commodity_browse_num = itemView.findViewById(R.id.commodity_browse_num);
        company_image = itemView.findViewById(R.id.company_image);
        commodity_image = itemView.findViewById(R.id.commodity_image);
    }
}
