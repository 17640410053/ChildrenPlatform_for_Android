package com.neusoft.yl.childrenplatform.Fragment.main_fragment;


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
import android.widget.LinearLayout;

import com.neusoft.yl.childrenplatform.Adapters.PartitionAdapter;
import com.neusoft.yl.childrenplatform.Adapters.TrendsAdapter;
import com.neusoft.yl.childrenplatform.Bean.TrendsBean;
import com.neusoft.yl.childrenplatform.Fragment.BaseFragment;
import com.neusoft.yl.childrenplatform.Listener.RetrofitListener;
import com.neusoft.yl.childrenplatform.Model.TrendsModel;
import com.neusoft.yl.childrenplatform.R;

import java.util.List;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrendsFragment extends BaseFragment implements RetrofitListener<List<TrendsBean>> {
    private RecyclerView trends_recycle;
    private SwipeRefreshLayout swipeRefreshLayout;

    public TrendsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        trends_recycle = view.findViewById(R.id.trends_recycle);
        swipeRefreshLayout = view.findViewById(R.id.srl);
        swipeRefreshLayout.setColorSchemeResources(R.color.color_pink);
        initData();
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Random random = new Random();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        initData();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                },1200);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trends, container, false);
    }

    @Override
    public void initView() {

    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void initData() {
        getTrends();
    }

    private void getTrends() {
        TrendsModel trendsModel = new TrendsModel();
        trendsModel.getTrends(this);
    }

    @Override
    public void onSuccess(List<TrendsBean> trendsBeans, int flag) {
        if (getActivity() != null) {
            TrendsAdapter adapter = new TrendsAdapter(getActivity(), trendsBeans);
            LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
            layoutManager.setOrientation(LinearLayout.VERTICAL);
            trends_recycle.setAdapter(adapter);
            trends_recycle.setLayoutManager(layoutManager);
            trends_recycle.setItemAnimator(new DefaultItemAnimator());
        }
    }

    @Override
    public void onFail() {

    }
}
