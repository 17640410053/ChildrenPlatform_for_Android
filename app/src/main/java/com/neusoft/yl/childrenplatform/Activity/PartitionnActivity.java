package com.neusoft.yl.childrenplatform.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.neusoft.yl.childrenplatform.Adapters.CompListAdapter;
import com.neusoft.yl.childrenplatform.Bean.CompBean;
import com.neusoft.yl.childrenplatform.Listener.RetrofitListener;
import com.neusoft.yl.childrenplatform.Model.CompModel;
import com.neusoft.yl.childrenplatform.R;

import java.util.List;

public class PartitionnActivity extends BaseActivity implements RetrofitListener<List<CompBean>>{
    private TextView partition_name;
    private RecyclerView partition_recycle;
    private Button back_btn;

    @Override
    void initViews() {

    }

    @Override
    void initEvents() {

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
        compModel.getCompPartition(getIntent().getIntExtra("id",-1),this);
    }

    @Override
    public void onSuccess(List<CompBean> compBeans, int flag) {
        CompListAdapter adapter = new CompListAdapter(this,compBeans);
        LinearLayoutManager layoutManager = new GridLayoutManager(this,2);
        layoutManager.setOrientation(GridLayoutManager.VERTICAL);
        partition_recycle.setAdapter(adapter);
        partition_recycle.setLayoutManager(layoutManager);
        partition_recycle.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void onFail() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partitionn);
        partition_name = findViewById(R.id.partition_name);
        partition_name.setText(getIntent().getStringExtra("name"));
        partition_recycle = findViewById(R.id.partition_recycle);
        initData();

        findViewById(R.id.back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
