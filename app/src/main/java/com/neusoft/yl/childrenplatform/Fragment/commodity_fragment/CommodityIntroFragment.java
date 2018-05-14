package com.neusoft.yl.childrenplatform.Fragment.commodity_fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.makeramen.roundedimageview.RoundedImageView;
import com.neusoft.yl.childrenplatform.Bean.CheckBean;
import com.neusoft.yl.childrenplatform.Bean.CommodityIntroBean;
import com.neusoft.yl.childrenplatform.Const;
import com.neusoft.yl.childrenplatform.Fragment.BaseFragment;
import com.neusoft.yl.childrenplatform.Listener.RetrofitListener;
import com.neusoft.yl.childrenplatform.Model.CompModel;
import com.neusoft.yl.childrenplatform.R;
import com.squareup.picasso.Picasso;

import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommodityIntroFragment extends BaseFragment implements RetrofitListener {

    private TextView commodity_title, commodity_browse_num, commodity_collect_num, commodity_detail, btn_follow, company_name, company_follow_num, text_is_collect;
    private RoundedImageView company_image;
    private LinearLayout liner_share, liner_collect;
    private ImageButton collect_image;
    private int company_id;

    private void showShare() {
        OnekeyShare oks = new OnekeyShare();
        oks.disableSSOWhenAuthorize();
        oks.setTitle("分享");
        oks.setTitleUrl("http://sharesdk.cn");
        oks.setText("我是分享文本");
        oks.setUrl("http://sharesdk.cn");
        oks.setComment("我是测试评论文本");
        oks.show(getActivity());
    }

    public CommodityIntroFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        commodity_title = view.findViewById(R.id.commodity_title);
        commodity_browse_num = view.findViewById(R.id.commodity_browse_num);
        commodity_collect_num = view.findViewById(R.id.commodity_collect_num);
        commodity_detail = view.findViewById(R.id.commodity_detail);
        btn_follow = view.findViewById(R.id.btn_follow);
        company_name = view.findViewById(R.id.company_name);
        company_follow_num = view.findViewById(R.id.company_follow_num);
        company_image = view.findViewById(R.id.company_image);
        liner_share = view.findViewById(R.id.liner_share);
        liner_collect = view.findViewById(R.id.liner_collect);
        text_is_collect = view.findViewById(R.id.text_is_collect);
        collect_image = view.findViewById(R.id.collect_image);
        initData();

        liner_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showShare();
            }
        });

        liner_collect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getCollect();
            }
        });

        btn_follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFollow(company_id);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_commodity_intro, container, false);
    }

    @Override
    public void initView() {

    }

    @Override
    public void onClick(View view) {
    }

    @Override
    public void initData() {
        getCommodityIntro();
        getIsCollect();
    }

    private void getCommodityIntro() {
        CompModel compModel = new CompModel();
        compModel.getCommodityIntro(getArguments().getString("commodity_id"), this);
    }

    private void getIsCollect() {
        CompModel compModel = new CompModel();
        compModel.getIsCollect(getArguments().getString("commodity_id"), getUserId(), this);
    }

    private void getCollect() {
        CompModel compModel = new CompModel();
        compModel.getCollect(getArguments().getString("commodity_id"), getUserId(), this);
    }

    private void getIsFollow(int company_id) {
        CompModel compModel = new CompModel();
        compModel.getIsFollow(company_id, getUserId(), this);
    }

    private void getFollow(int company_id) {
        CompModel compModel = new CompModel();
        compModel.getFollow(company_id, getUserId(), this);
    }

    @Override
    public void onSuccess(Object o, int flag) {
        switch (flag) {
            case Const.GETCOMMODITYINTRO:
                CommodityIntroBean commodityIntroBean = (CommodityIntroBean) o;
                commodity_title.setText(commodityIntroBean.getName());
                commodity_browse_num.setText(commodityIntroBean.getHintnum() + "浏览");
                commodity_collect_num.setText(commodityIntroBean.getCollectnum() + "收藏");
                if (commodityIntroBean.getDetail().equals("")) {
                    commodity_detail.setText("该商品尚未填写详情。");
                } else {
                    commodity_detail.setText(commodityIntroBean.getDetail());
                }
                company_follow_num.setText(commodityIntroBean.getFollow_num() + "粉丝");
                company_name.setText(commodityIntroBean.getCompany_name());
                String url = Const.PIC_URL + "company_image/" + commodityIntroBean.getCompany_image();
                Picasso.with(getActivity()).load(url).into(company_image);
                company_id = commodityIntroBean.getCompany_id();
                getIsFollow(commodityIntroBean.getCompany_id());
                break;
            case Const.ISCOLLECT:
                CheckBean isCollectBean = (CheckBean) o;
                if (isCollectBean.getCode().equals("200")) {
                    collect_image.setBackgroundResource(R.drawable.ic_collect_no);
                    text_is_collect.setText(isCollectBean.getMessage());
                } else if (isCollectBean.getCode().equals("300")) {
                    collect_image.setBackgroundResource(R.drawable.ic_collect_is);
                    text_is_collect.setText(isCollectBean.getMessage());
                }
                break;
            case Const.COLLECT:
                CheckBean collectBean = (CheckBean) o;
                if (collectBean.getCode().equals("200")) {
                    collect_image.setBackgroundResource(R.drawable.ic_collect_no);
                    text_is_collect.setText(collectBean.getMessage());
                } else {
                    collect_image.setBackgroundResource(R.drawable.ic_collect_is);
                    text_is_collect.setText(collectBean.getMessage());
                }
                break;
            case Const.ISFOLLOW:
                CheckBean isFollowBean = (CheckBean) o;
                if (isFollowBean.getCode().equals("200")) {
                    btn_follow.setText(isFollowBean.getMessage());
                }
                break;
            case Const.FOLLOW:
                CheckBean followBean = (CheckBean) o;
                if (followBean.getCode().equals("200")){
                    btn_follow.setText(followBean.getMessage());
                }
                break;
        }
    }

    @Override
    public void onFail() {
        Toast.makeText(getActivity(), "网络错误", Toast.LENGTH_SHORT).show();
    }
}
