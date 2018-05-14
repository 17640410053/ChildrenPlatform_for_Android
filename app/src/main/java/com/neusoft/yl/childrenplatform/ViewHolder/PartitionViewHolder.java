package com.neusoft.yl.childrenplatform.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.neusoft.yl.childrenplatform.R;

public class PartitionViewHolder extends RecyclerView.ViewHolder {
    public ImageView image_partition;
    public TextView text_partition;

    public View itemView;

    public PartitionViewHolder(View itemView) {
        super(itemView);

        this.itemView = itemView;
        image_partition = itemView.findViewById(R.id.image_partition);
        text_partition = itemView.findViewById(R.id.text_partition);
    }
}
