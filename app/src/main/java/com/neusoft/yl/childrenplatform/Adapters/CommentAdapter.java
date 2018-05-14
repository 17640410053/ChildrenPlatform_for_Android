package com.neusoft.yl.childrenplatform.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.neusoft.yl.childrenplatform.Bean.CommentBean;
import com.neusoft.yl.childrenplatform.Const;
import com.neusoft.yl.childrenplatform.R;
import com.neusoft.yl.childrenplatform.ViewHolder.CommentViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CommentAdapter extends BaseAdapter {
    public CommentAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    RecyclerView.ViewHolder onCreateVH(ViewGroup parent, LayoutInflater layoutInflater, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.item_comment_list, parent, false);
        CommentViewHolder viewHolder = new CommentViewHolder(itemView);
        return viewHolder;
    }

    @Override
    void onBindVH(RecyclerView.ViewHolder holder, List data, int position) {
        CommentBean commentBean = (CommentBean) data.get(position);
        if (holder instanceof CommentViewHolder) {
            CommentViewHolder viewHolder = (CommentViewHolder) holder;
            String url = Const.PIC_URL + "user_image/" + commentBean.getUser_image();
            viewHolder.comment_user.setText(commentBean.getUsername());
            viewHolder.comment_time.setText(commentBean.getDatetime());
            viewHolder.comment_detail.setText(commentBean.getDetails());
            Picasso.with(context).load(url).into(viewHolder.comment_header);
        }
    }
}
