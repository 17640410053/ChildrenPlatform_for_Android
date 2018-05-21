package com.neusoft.yl.childrenplatform.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.neusoft.yl.childrenplatform.Adapters.CollectListAdapter;
import com.neusoft.yl.childrenplatform.Adapters.OrderAdapter;
import com.neusoft.yl.childrenplatform.Bean.OrderBean;
import com.neusoft.yl.childrenplatform.Fragment.BaseFragment;
import com.neusoft.yl.childrenplatform.Listener.RetrofitListener;
import com.neusoft.yl.childrenplatform.Model.UserModel;
import com.neusoft.yl.childrenplatform.R;

import java.util.List;

public class OrderActivity extends BaseActivity implements RetrofitListener<List<OrderBean>> {
    private RecyclerView order_recycle;
    private Button back_btn;

    @Override
    void initViews() {

    }

    @Override
    void initEvents() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        order_recycle = findViewById(R.id.order_recycle);
        initData();

        findViewById(R.id.back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void initView() {

    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void initData() {
        UserModel userModel  = new UserModel();
        userModel.getUserOrder(getUser_id(),this);
    }

    @Override
    public void onSuccess(List<OrderBean> orderBeans, int flag) {
        OrderAdapter adapter = new OrderAdapter(this,orderBeans);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        order_recycle.setAdapter(adapter);
        order_recycle.setLayoutManager(layoutManager);
        order_recycle.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void onFail() {
        showToast("网路错误");
    }
}
