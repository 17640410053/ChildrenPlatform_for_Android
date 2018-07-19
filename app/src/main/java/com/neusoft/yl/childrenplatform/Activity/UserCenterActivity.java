package com.neusoft.yl.childrenplatform.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.neusoft.yl.childrenplatform.Bean.UserCenterBean;
import com.neusoft.yl.childrenplatform.Const;
import com.neusoft.yl.childrenplatform.Fragment.userfragment.UserCollectFragment;
import com.neusoft.yl.childrenplatform.Fragment.userfragment.UserFollowFragment;
import com.neusoft.yl.childrenplatform.Fragment.userfragment.UserHomeFragment;
import com.neusoft.yl.childrenplatform.Listener.RetrofitListener;
import com.neusoft.yl.childrenplatform.Model.UserModel;
import com.neusoft.yl.childrenplatform.R;
import com.squareup.picasso.Picasso;

public class UserCenterActivity extends BaseActivity implements RetrofitListener<UserCenterBean> {

    private CollapsingToolbarLayoutState state;
    private TextView toolbar_username, text_username, text_collect_num, text_intro;
    private ImageView user_sex;
    private RoundedImageView user_header_img;
    private Button back_btn, user_data_btn;
    private String pic, username, uid, sex, address, intro, email;
    private RadioGroup radioGroup_user_center;

    private UserCollectFragment userCollectFragment;
    private UserFollowFragment userFollowFragment;
    private UserHomeFragment userHomeFragment;

    private FragmentTransaction transaction;
    private FragmentManager fragmentManager;

    private void replace(Fragment fragment) {
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.user_center_fragment, fragment);
        transaction.commit();
    }

    //监听CollapsingToolbarLayout的状态
    private enum CollapsingToolbarLayoutState {
        EXPANDED, //展开
        COLLAPSED, //折叠
        INTERNEDIATE //中间态
    }

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_center);
        AppBarLayout app_bar = findViewById(R.id.app_bar);
        initViews();
        initData();
        app_bar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset == 0) {
                    if (state != CollapsingToolbarLayoutState.EXPANDED) {
                        state = CollapsingToolbarLayoutState.EXPANDED;
                        toolbar_username.setText("");
                    }
                } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
                    if (state != CollapsingToolbarLayoutState.COLLAPSED) {
                        state = CollapsingToolbarLayoutState.COLLAPSED;
                        toolbar_username.setText(text_username.getText().toString());
                    }
                } else {
                    if (state != CollapsingToolbarLayoutState.INTERNEDIATE) {
                        if (state == CollapsingToolbarLayoutState.COLLAPSED) {
                        }
                        state = CollapsingToolbarLayoutState.INTERNEDIATE;
                    }
                }
            }
        });

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        user_data_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserCenterActivity.this, UserDataActivity.class);
                intent.putExtra("pic", pic);
                intent.putExtra("sex", sex);
                intent.putExtra("username", username);
                intent.putExtra("uid", uid);
                intent.putExtra("address", address);
                intent.putExtra("intro", intro);
                startActivityForResult(intent, 778);
            }
        });

        radioGroup_user_center.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radio_user_home:
                        userHomeFragment = new UserHomeFragment();
                        replace(userHomeFragment);
                        break;
                    case R.id.radio_user_collect:
                        userCollectFragment = new UserCollectFragment();
                        replace(userCollectFragment);
                        break;
                    case R.id.radio_user_follow:
                        userFollowFragment = new UserFollowFragment();
                        replace(userFollowFragment);
                        break;
                }
            }
        });
        radioGroup_user_center.check(R.id.radio_user_home);
    }

    @Override
    void initViews() {
        text_username = findViewById(R.id.text_username);
        text_collect_num = findViewById(R.id.text_collect_num);
        text_intro = findViewById(R.id.text_intro);
        user_sex = findViewById(R.id.user_sex);
        user_header_img = findViewById(R.id.user_header_img);
        toolbar_username = findViewById(R.id.toolbar_username);
        back_btn = findViewById(R.id.back_btn);
        user_data_btn = findViewById(R.id.user_data_btn);
        radioGroup_user_center = findViewById(R.id.radioGroup_user_center);
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

    }

    @Override
    public void initData() {
        UserModel userModel = new UserModel();
        userModel.userInformation(getUser_id(), this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 778) {
            switch (resultCode) {
                case RESULT_CANCELED:
                    if (getUser_id().equals("-1")) {
                        finish();
                    } else {
                        initData();
                    }
            }
        }
    }

    @Override
    public void onSuccess(UserCenterBean userCenterBean, int flag) {
        pic = userCenterBean.getImage();
        username = userCenterBean.getUsername();
        uid = userCenterBean.getUser_id();
        sex = userCenterBean.getGender();
        address = userCenterBean.getAddress();
        intro = userCenterBean.getIntro();
        email = userCenterBean.getEmail();

        String url = Const.PIC_URL + "user_image/" + pic;
        text_username.setText(username);
        text_collect_num.setText(userCenterBean.getCollect_num());
        if (intro != null && !intro.equals("")) {
            text_intro.setText(intro);
        } else {
            text_intro.setText("这个人很懒死了，什么都没有写(｡・`ω´･)");
        }
        if (!sex.equals("3")) {
            if (sex.equals("1")) {
                user_sex.setImageResource(R.drawable.ic_sex_boy);
            }
            if (sex.equals("0")) {
                user_sex.setImageResource(R.drawable.ic_sex_girl);
            }
        } else {
            user_sex.setImageResource(R.drawable.ic_sex);
        }
        Picasso.with(this).load(url).into(user_header_img);


    }

    @Override
    public void onFail() {
        showToast("请检查你的网络再试");
    }
}
