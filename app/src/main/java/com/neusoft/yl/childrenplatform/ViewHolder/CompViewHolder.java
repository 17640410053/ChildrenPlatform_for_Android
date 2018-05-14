package com.neusoft.yl.childrenplatform.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.neusoft.yl.childrenplatform.R;


public class CompViewHolder extends RecyclerView.ViewHolder {
    public TextView text_browse, text_comment, text_name, text_type, text_child_type;
    public RoundedImageView comp_img;

    public View itemView;

    public CompViewHolder(View itemView) {
        super(itemView);

        this.itemView = itemView;
        text_browse = itemView.findViewById(R.id.text_browse);
        text_comment = itemView.findViewById(R.id.text_comment);
        text_name = itemView.findViewById(R.id.text_name);
        text_type = itemView.findViewById(R.id.text_type);
        text_child_type = itemView.findViewById(R.id.text_child_type);
        comp_img = itemView.findViewById(R.id.comp_img);
    }
}
