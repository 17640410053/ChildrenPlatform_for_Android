package com.neusoft.yl.childrenplatform.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.neusoft.yl.childrenplatform.R;

public class CommentViewHolder extends RecyclerView.ViewHolder {
    public TextView comment_user,comment_time,comment_detail;
    public RoundedImageView comment_header;

    public CommentViewHolder(View itemView) {
        super(itemView);
        comment_user = itemView.findViewById(R.id.comment_user);
        comment_time = itemView.findViewById(R.id.comment_time);
        comment_detail = itemView.findViewById(R.id.comment_detail);
        comment_header = itemView.findViewById(R.id.comment_header);
    }
}
