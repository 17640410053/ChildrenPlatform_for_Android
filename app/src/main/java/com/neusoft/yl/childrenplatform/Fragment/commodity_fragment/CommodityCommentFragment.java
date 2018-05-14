package com.neusoft.yl.childrenplatform.Fragment.commodity_fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.neusoft.yl.childrenplatform.Adapters.CollectListAdapter;
import com.neusoft.yl.childrenplatform.Adapters.CommentAdapter;
import com.neusoft.yl.childrenplatform.Bean.CommentBean;
import com.neusoft.yl.childrenplatform.Fragment.BaseFragment;
import com.neusoft.yl.childrenplatform.Listener.RetrofitListener;
import com.neusoft.yl.childrenplatform.Model.CompModel;
import com.neusoft.yl.childrenplatform.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommodityCommentFragment extends BaseFragment implements RetrofitListener<List<CommentBean>>{
    private RecyclerView comment_recycl;

    public CommodityCommentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        comment_recycl = view.findViewById(R.id.comment_recycle);
        initData();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_commodity_comment, container, false);
    }

    @Override
    public void initView() {

    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void initData() {
        CompModel compModel = new CompModel();
        compModel.getCommodityComment(getArguments().getString("commodity_id"),this);
    }

    @Override
    public void onSuccess(List<CommentBean> commentBeans, int flag) {
        CommentAdapter adapter = new CommentAdapter(getActivity(),commentBeans);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        comment_recycl.setAdapter(adapter);
        comment_recycl.setLayoutManager(layoutManager);
        comment_recycl.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void onFail() {
        Toast.makeText(getActivity(), "网络错误", Toast.LENGTH_SHORT).show();
    }
}
