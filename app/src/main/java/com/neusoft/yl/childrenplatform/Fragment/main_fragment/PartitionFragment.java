package com.neusoft.yl.childrenplatform.Fragment.main_fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.neusoft.yl.childrenplatform.Adapters.CompListAdapter;
import com.neusoft.yl.childrenplatform.Adapters.PartitionAdapter;
import com.neusoft.yl.childrenplatform.Bean.PartitionBean;
import com.neusoft.yl.childrenplatform.Fragment.BaseFragment;
import com.neusoft.yl.childrenplatform.Listener.RetrofitListener;
import com.neusoft.yl.childrenplatform.Model.PartitionModel;
import com.neusoft.yl.childrenplatform.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PartitionFragment extends BaseFragment implements RetrofitListener<List<PartitionBean>>{
    private RecyclerView partition_recycle;

    public PartitionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        partition_recycle = view.findViewById(R.id.partition_recycle);
        initData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_partition, container, false);
    }

    @Override
    public void initView() {

    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void initData() {
        getPartition();
    }

    private void getPartition(){
        PartitionModel partitionModel = new PartitionModel();
        partitionModel.getPartition(this);
    }

    @Override
    public void onSuccess(List<PartitionBean> partitionBeans, int flag) {
        if (getActivity()!= null){
            PartitionAdapter adapter = new PartitionAdapter(getActivity(),partitionBeans);
            LinearLayoutManager layoutManager = new GridLayoutManager(getActivity(),4);
            layoutManager.setOrientation(GridLayoutManager.VERTICAL);
            partition_recycle.setAdapter(adapter);
            partition_recycle.setLayoutManager(layoutManager);
            partition_recycle.setItemAnimator(new DefaultItemAnimator());
        }
    }

    @Override
    public void onFail() {

    }
}
