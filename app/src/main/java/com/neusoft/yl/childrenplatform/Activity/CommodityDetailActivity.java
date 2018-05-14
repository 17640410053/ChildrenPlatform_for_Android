package com.neusoft.yl.childrenplatform.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.neusoft.yl.childrenplatform.Bean.CompBean;
import com.neusoft.yl.childrenplatform.Const;
import com.neusoft.yl.childrenplatform.Fragment.commodity_fragment.CommodityCommentFragment;
import com.neusoft.yl.childrenplatform.Fragment.commodity_fragment.CommodityIntroFragment;
import com.neusoft.yl.childrenplatform.Listener.RetrofitListener;
import com.neusoft.yl.childrenplatform.Model.CompModel;
import com.neusoft.yl.childrenplatform.R;
import com.squareup.picasso.Picasso;

public class CommodityDetailActivity extends BaseActivity implements RetrofitListener<CompBean> {

    private RadioGroup radioGroup_commodity_detail;
    private ImageView commodity_image;
    private TextView toolbar_commodity_name;

    private CommodityCommentFragment commodityCommentFragment;
    private CommodityIntroFragment commodityIntroFragment;

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;

    private void replace(Fragment fragment) {
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.commodity_fragment, fragment);
        transaction.commit();
    }

    @Override
    void initViews() {
        radioGroup_commodity_detail = findViewById(R.id.radioGroup_commodity_detail);
        toolbar_commodity_name = findViewById(R.id.toolbar_commodity_name);
        commodity_image = findViewById(R.id.commodity_image);
        fragmentManager = getSupportFragmentManager();
    }

    @Override
    void initEvents() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_btn:
                finish();
                break;
        }
    }

    @Override
    public void initData() {
        CompModel compModel = new CompModel();
        compModel.getCommodityDetail(getIntent().getStringExtra("commodity_id"),this);
    }

    @Override
    public void onSuccess(CompBean compBean, int flag) {
        String url = Const.PIC_URL + "commodity_image/" + compBean.getMiddle_pic();
        Picasso.with(this).load(url).into(commodity_image);
        toolbar_commodity_name.setText(compBean.getName());
    }

    @Override
    public void onFail() {
        showToast("网络错误");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commodity_detail);
        initViews();
        initData();

        radioGroup_commodity_detail.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                Bundle bundle = new Bundle();
                bundle.putString("commodity_id",getIntent().getStringExtra("commodity_id"));
                switch (i) {
                    case R.id.radio_commodity_intro:
                        commodityIntroFragment = new CommodityIntroFragment();;
                        commodityIntroFragment.setArguments(bundle);
                        replace(commodityIntroFragment);
                        break;
                    case R.id.radio_commodity_comment:
                        commodityCommentFragment = new CommodityCommentFragment();
                        commodityCommentFragment.setArguments(bundle);
                        replace(commodityCommentFragment);
                        break;
                }
            }
        });
        radioGroup_commodity_detail.check(R.id.radio_commodity_intro);
    }
}
