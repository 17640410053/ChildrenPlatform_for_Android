package com.neusoft.yl.childrenplatform.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.neusoft.yl.childrenplatform.Bean.UserCenterBean;
import com.neusoft.yl.childrenplatform.Const;
import com.neusoft.yl.childrenplatform.Fragment.main_fragment.HomeFragment;
import com.neusoft.yl.childrenplatform.Fragment.main_fragment.NewsFragment;
import com.neusoft.yl.childrenplatform.Fragment.main_fragment.PartitionFragment;
import com.neusoft.yl.childrenplatform.Fragment.main_fragment.TrendsFragment;
import com.neusoft.yl.childrenplatform.R;
import com.neusoft.yl.childrenplatform.Service.RetrofitService;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TextView text_username, text_telephone, text_header;
    private RoundedImageView head_img;
    private RadioGroup radioGroup_main;
    private Toolbar toolbar;

    //存储用户ID
    private SharedPreferences sharedPreferences;
    private String filename = "cpform";
    private int MODE = MODE_PRIVATE;

    private HomeFragment homeFragment;
    private NewsFragment newsFragment;
    private PartitionFragment partitionFragment;
    private TrendsFragment trendsFragment;

    private FragmentTransaction transaction;
    private FragmentManager fragmentManager;
    long firstTime = 0;

    //点击两次返回退出程序
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            long secondTime = System.currentTimeMillis();
            if (secondTime - firstTime > 800) {//如果两次按键间隔大于800毫秒则不退出
                showToast("再按一次退出程序");
                firstTime = secondTime;
                return true;
            } else {
                System.exit(0);
            }
        }
        return super.onKeyUp(keyCode, event);
    }

    private void replace(Fragment fragment) {
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_fragment, fragment);
        transaction.commit();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences(filename, MODE);
        radioGroup_main = findViewById(R.id.radioGroup_main);
        text_header = findViewById(R.id.text_header);
        fragmentManager = getSupportFragmentManager();
        toolbar = findViewById(R.id.toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        final View nav_header_main = navigationView.inflateHeaderView(R.layout.nav_header_main);
        text_username = nav_header_main.findViewById(R.id.text_username);
        text_telephone = nav_header_main.findViewById(R.id.text_telephone);
        head_img = nav_header_main.findViewById(R.id.head_img);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);

        if (isLogined()) {
            user_id = readUserId();
            get_user_information();
            head_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, UserCenterActivity.class);
                    startActivityForResult(intent, 120);
                }
            });
        } else {
            head_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivityForResult(intent, 520);
                }
            });
        }

        radioGroup_main.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radio_home:
                        homeFragment = new HomeFragment();
                        replace(homeFragment);
                        text_header.setText("首页");
                        break;
                    case R.id.radio_partition:
                        partitionFragment = new PartitionFragment();
                        replace(partitionFragment);
                        ;
                        text_header.setText("分区");
                        break;
                    case R.id.radio_trends:
                        trendsFragment = new TrendsFragment();
                        replace(trendsFragment);
                        ;
                        text_header.setText("动态");
                        break;
                    case R.id.radio_news:
                        newsFragment = new NewsFragment();
                        replace(newsFragment);
                        ;
                        text_header.setText("消息");
                        break;
                }
            }
        });
        radioGroup_main.check(R.id.radio_home);
    }

    private void get_header(String url) {
        Picasso.with(this).load(url).into(head_img);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 520) {
            switch (resultCode) {
                case RESULT_OK:
                    get_user_information();
                    head_img.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(MainActivity.this, UserCenterActivity.class);
                            startActivityForResult(intent, 120);
                        }
                    });
                    break;
                case RESULT_CANCELED:
                    break;
            }
        } else if (requestCode == 120) {
            switch (resultCode) {
                case RESULT_CANCELED:
                    if (getUser_id().equals("-1")) {
                        head_img.setImageResource(R.drawable.test);
                        text_username.setText("点击头像登录");
                        text_telephone.setText("");
                        head_img.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                                startActivityForResult(intent, 520);
                            }
                        });
                    } else {
                        get_user_information();
                    }
            }
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
        } else if (id == R.id.nav_collect) {
            if (isLogined()) {
                startActivity(new Intent(MainActivity.this, CollectActivity.class));
            } else {
                showToast("你还未登录！");
            }
        } else if (id == R.id.nav_slideshow) {
            showToast("都说了没有，你怎么还点呢 ( ・◇・)？");
        } else if (id == R.id.nav_manage) {
            showToast("你再点试试？(＃｀皿´)");
        } else if (id == R.id.nav_share) {
            showToast("你咋这么听话呢 (╯‵□′)╯︵┻━┻");
        } else if (id == R.id.nav_send) {
            showToast("好吧，再见！∑(っ °Д °;)っ");
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    System.exit(0);
                }
            }, 2000);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //拉取用户数据
    private void get_user_information() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Const.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitService retrofitService = retrofit.create(RetrofitService.class);
        Call<UserCenterBean> userCenterBeanCall = retrofitService.getUserInformation(getUser_id());
        userCenterBeanCall.enqueue(new Callback<UserCenterBean>() {
            @Override
            public void onResponse(Call<UserCenterBean> call, Response<UserCenterBean> response) {
                UserCenterBean userCenterBean = response.body();
                String url = Const.PIC_URL + "user_image/" + userCenterBean.getImage();
                text_username.setText(userCenterBean.getUsername());
                text_telephone.setText(userCenterBean.getEmail());
                get_header(url);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("email", userCenterBean.getEmail());
                editor.putString("username", userCenterBean.getUsername());
                editor.putString("user_pic", userCenterBean.getImage());
                editor.commit();
            }

            @Override
            public void onFailure(Call<UserCenterBean> call, Throwable t) {
                showToast("请检查你的网络");
                text_username.setText(sharedPreferences.getString("username", ""));
                text_telephone.setText(sharedPreferences.getString("email", ""));
                String url = Const.PIC_URL + "userpic/" + sharedPreferences.getString("user_pic", "");
                get_header(url);
            }
        });
    }

    private void hideFragment() {
        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
        if (newsFragment != null) {
            transaction.hide(newsFragment);
        }
        if (partitionFragment != null) {
            transaction.hide(partitionFragment);
        }
        if (trendsFragment != null) {
            transaction.hide(trendsFragment);
        }
    }

    @Override
    void initViews() {

    }

    @Override
    void initEvents() {

    }

    @Override
    void initData() {

    }

    private boolean isLogined() {
        String userId = readUserId();
        return !userId.equals("-1");//不为0表示登录过
    }

    private String readUserId() {
        String userId = sharedPreferences.getString("userID", "-1");
        return userId;
    }
}
