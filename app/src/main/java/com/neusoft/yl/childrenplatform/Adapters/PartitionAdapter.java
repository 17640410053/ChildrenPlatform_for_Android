package com.neusoft.yl.childrenplatform.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.neusoft.yl.childrenplatform.Bean.PartitionBean;
import com.neusoft.yl.childrenplatform.Const;
import com.neusoft.yl.childrenplatform.R;
import com.neusoft.yl.childrenplatform.ViewHolder.PartitionViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PartitionAdapter extends BaseAdapter {
    public PartitionAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    RecyclerView.ViewHolder onCreateVH(ViewGroup parent, LayoutInflater layoutInflater, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.item_partition_list, parent, false);
        PartitionViewHolder viewHolder = new PartitionViewHolder(itemView);
        return viewHolder;
    }

    @Override
    void onBindVH(RecyclerView.ViewHolder holder, List data, int position) {
        PartitionBean partitionBean = (PartitionBean) data.get(position);
        if (holder instanceof PartitionViewHolder){
            PartitionViewHolder viewHolder = (PartitionViewHolder) holder;
            viewHolder.text_partition.setText(partitionBean.getName());
            String url = Const.PIC_URL + "type_icon/" + partitionBean.getImage();
            Picasso.with(context).load(url).into(viewHolder.image_partition);
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "11", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
