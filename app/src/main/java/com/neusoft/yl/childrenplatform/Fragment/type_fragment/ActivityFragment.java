package com.neusoft.yl.childrenplatform.Fragment.type_fragment;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.neusoft.yl.childrenplatform.Adapters.CompListAdapter;
import com.neusoft.yl.childrenplatform.Bean.CompBean;
import com.neusoft.yl.childrenplatform.Fragment.BaseFragment;
import com.neusoft.yl.childrenplatform.Listener.RetrofitListener;
import com.neusoft.yl.childrenplatform.Model.TypeModel;
import com.neusoft.yl.childrenplatform.R;

import java.util.List;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class ActivityFragment extends BaseFragment implements RetrofitListener<List<CompBean>> {

    private RecyclerView activity_recycle;
    private SwipeRefreshLayout swipeRefreshLayout;

    public ActivityFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        activity_recycle = view.findViewById(R.id.activity_recycle);
        swipeRefreshLayout = view.findViewById(R.id.srl);
        swipeRefreshLayout.setColorSchemeResources(R.color.color_pink);
        swipeRefreshLayout.setRefreshing(true);
        initData();
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initData();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_activity, container, false);
    }

    @Override
    public void initView() {

    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void initData() {
        TypeModel typeModel = new TypeModel();
        typeModel.getTypeList(2, this);
    }

    @Override
    public void onSuccess(List<CompBean> compBeen, int flag) {
        if (getActivity() != null) {
            CompListAdapter adapter = new CompListAdapter(getActivity(), compBeen);
            LinearLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
            layoutManager.setOrientation(GridLayoutManager.VERTICAL);
            activity_recycle.setAdapter(adapter);
            activity_recycle.setLayoutManager(layoutManager);
            activity_recycle.setItemAnimator(new DefaultItemAnimator());
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void onFail() {

    }
}
