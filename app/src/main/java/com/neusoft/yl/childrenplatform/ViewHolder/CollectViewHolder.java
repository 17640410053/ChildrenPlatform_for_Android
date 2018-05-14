package com.neusoft.yl.childrenplatform.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.neusoft.yl.childrenplatform.R;

/**
 * Created by Kirito on 2017/12/2.
 */

public class CollectViewHolder extends RecyclerView.ViewHolder {

    public TextView collect_name, hint_num, comment_num;
    public RoundedImageView collect_pic;

    public View itemView;

    public CollectViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
        collect_name = itemView.findViewById(R.id.collect_name);
        comment_num = itemView.findViewById(R.id.comment_num);
        hint_num = itemView.findViewById(R.id.hint_num);
        collect_pic = itemView.findViewById(R.id.collect_pic);
    }
}
