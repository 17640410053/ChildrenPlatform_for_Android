package com.neusoft.yl.childrenplatform.Fragment.main_fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.neusoft.yl.childrenplatform.Adapters.HomeFragmentPagerAdapter;
import com.neusoft.yl.childrenplatform.Fragment.type_fragment.ActivityFragment;
import com.neusoft.yl.childrenplatform.Fragment.type_fragment.DressFragment;
import com.neusoft.yl.childrenplatform.Fragment.type_fragment.FoodFragment;
import com.neusoft.yl.childrenplatform.Fragment.type_fragment.RecommendFragment;
import com.neusoft.yl.childrenplatform.Fragment.type_fragment.TrainFragment;
import com.neusoft.yl.childrenplatform.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    //头标
    private TextView recommend_text, food_text, activity_text, dress_text, train_text;
    //Tab滑动效果
    private ViewPager viewPager;
    //动画图片
    private ImageView cursor;
    //动画图片偏移量
    private int offset = 0;
    private int position_food;
    private int position_activity;
    private int position_dress;
    private int position_train;
    //动画图片宽度
    private int bmpW;
    //当前页卡编号
    private int currIndex = 0;
    //存放Fragment
    private ArrayList<Fragment> fragmentArrayList;
    //管理Fragment
    private FragmentManager fragmentManager;
    public Context context;
    public static final String TAG = "MainActivity";

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        context = getActivity();
        //初始化头标
        recommend_text = view.findViewById(R.id.recommend_text);
        food_text = view.findViewById(R.id.food_text);
        activity_text = view.findViewById(R.id.activity_text);
        dress_text = view.findViewById(R.id.dress_text);
        train_text = view.findViewById(R.id.train_text);
        //头标点击监听
        recommend_text.setOnClickListener(new MyOnClickListener(0));
        food_text.setOnClickListener(new MyOnClickListener(1));
        activity_text.setOnClickListener(new MyOnClickListener(2));
        dress_text.setOnClickListener(new MyOnClickListener(3));
        train_text.setOnClickListener(new MyOnClickListener(4));
        //初始化动画
        cursor = view.findViewById(R.id.cursor);
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        //获取分辨率宽度
        int screenW = dm.widthPixels;
        bmpW = (screenW / 5);
        //设置动画图片宽度
//        setBmpW(cursor,bmpW);
        offset = 0;
        //动画偏移量赋值
        position_food = (int) (screenW / 5.0);
        position_activity = position_food * 2;
        position_dress = position_food * 3;
        position_train = position_activity * 2;
        //初始化fragment
        fragmentArrayList = new ArrayList<Fragment>();
        fragmentArrayList.add(new RecommendFragment());
        fragmentArrayList.add(new FoodFragment());
        fragmentArrayList.add(new ActivityFragment());
        fragmentArrayList.add(new DressFragment());
        fragmentArrayList.add(new TrainFragment());
        fragmentManager = getChildFragmentManager();
        //初始化页卡内容
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        viewPager.setAdapter(new HomeFragmentPagerAdapter(fragmentManager, fragmentArrayList));
        viewPager.setOffscreenPageLimit(4);
        viewPager.setCurrentItem(0);
        resetTextViewTextColor();
        recommend_text.setTextColor(getResources().getColor(R.color.color_withe));
        viewPager.setOnPageChangeListener(new MyOnPageChangeListener());
    }

    //头标点击监听
    public class MyOnClickListener implements View.OnClickListener {
        private int index = 0;

        public MyOnClickListener(int i) {
            index = i;
        }

        @Override
        public void onClick(View view) {
            viewPager.setCurrentItem(index);
        }
    }

    //页卡切换监听
    public class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageSelected(int position) {
            Animation animation = null;
            switch (position) {
                case 0:
                    if (currIndex == 1) {
                        animation = new TranslateAnimation(position_food, 0, 0, 0);
                        resetTextViewTextColor();
                        recommend_text.setTextColor(getResources().getColor(R.color.color_withe));
                    } else if (currIndex == 4) {
                        animation = new TranslateAnimation(position_train, 0, 0, 0);
                        resetTextViewTextColor();
                        recommend_text.setTextColor(getResources().getColor(R.color.color_withe));
                    } else if (currIndex == 2) {
                        animation = new TranslateAnimation(position_activity, 0, 0, 0);
                        resetTextViewTextColor();
                        recommend_text.setTextColor(getResources().getColor(R.color.color_withe));
                    } else if (currIndex == 3) {
                        animation = new TranslateAnimation(position_dress, 0, 0, 0);
                        resetTextViewTextColor();
                        recommend_text.setTextColor(getResources().getColor(R.color.color_withe));
                    }
                    break;
                case 1:
                    if (currIndex == 0) {
                        animation = new TranslateAnimation(offset, position_food, 0, 0);
                        resetTextViewTextColor();
                        food_text.setTextColor(getResources().getColor(R.color.color_withe));
                    } else if (currIndex == 2) {
                        animation = new TranslateAnimation(position_activity, position_food, 0, 0);
                        resetTextViewTextColor();
                        food_text.setTextColor(getResources().getColor(R.color.color_withe));
                    } else if (currIndex == 3) {
                        animation = new TranslateAnimation(position_dress, position_food, 0, 0);
                        resetTextViewTextColor();
                        food_text.setTextColor(getResources().getColor(R.color.color_withe));
                    } else if (currIndex == 4) {
                        animation = new TranslateAnimation(position_train, position_food, 0, 0);
                        resetTextViewTextColor();
                        food_text.setTextColor(getResources().getColor(R.color.color_withe));
                    }
                    break;
                case 2:
                    if (currIndex == 0) {
                        animation = new TranslateAnimation(offset, position_activity, 0, 0);
                        resetTextViewTextColor();
                        activity_text.setTextColor(getResources().getColor(R.color.color_withe));
                    } else if (currIndex == 1) {
                        animation = new TranslateAnimation(position_food, position_activity, 0, 0);
                        resetTextViewTextColor();
                        activity_text.setTextColor(getResources().getColor(R.color.color_withe));
                    } else if (currIndex == 3) {
                        animation = new TranslateAnimation(position_dress, position_activity, 0, 0);
                        resetTextViewTextColor();
                        activity_text.setTextColor(getResources().getColor(R.color.color_withe));
                    } else if (currIndex == 4) {
                        animation = new TranslateAnimation(position_train, position_activity, 0, 0);
                        resetTextViewTextColor();
                        activity_text.setTextColor(getResources().getColor(R.color.color_withe));
                    }
                    break;
                case 3:
                    if (currIndex == 0) {
                        animation = new TranslateAnimation(offset, position_dress, 0, 0);
                        resetTextViewTextColor();
                        dress_text.setTextColor(getResources().getColor(R.color.color_withe));
                    } else if (currIndex == 1) {
                        animation = new TranslateAnimation(position_food, position_dress, 0, 0);
                        resetTextViewTextColor();
                        dress_text.setTextColor(getResources().getColor(R.color.color_withe));
                    } else if (currIndex == 2) {
                        animation = new TranslateAnimation(position_activity, position_dress, 0, 0);
                        resetTextViewTextColor();
                        dress_text.setTextColor(getResources().getColor(R.color.color_withe));
                    } else if (currIndex == 4) {
                        animation = new TranslateAnimation(position_train, position_dress, 0, 0);
                        resetTextViewTextColor();
                        dress_text.setTextColor(getResources().getColor(R.color.color_withe));
                    }
                    break;
                case 4:
                    if (currIndex == 3) {
                        animation = new TranslateAnimation(position_dress, position_train, 0, 0);
                        resetTextViewTextColor();
                        train_text.setTextColor(getResources().getColor(R.color.color_withe));
                    } else if (currIndex == 2) {
                        animation = new TranslateAnimation(position_activity, position_train, 0, 0);
                        resetTextViewTextColor();
                        train_text.setTextColor(getResources().getColor(R.color.color_withe));
                    } else if (currIndex == 1) {
                        animation = new TranslateAnimation(position_food, position_train, 0, 0);
                        resetTextViewTextColor();
                        train_text.setTextColor(getResources().getColor(R.color.color_withe));
                    } else if (currIndex == 0) {
                        animation = new TranslateAnimation(offset, position_train, 0, 0);
                        resetTextViewTextColor();
                        train_text.setTextColor(getResources().getColor(R.color.color_withe));
                    }
                    break;
            }
            currIndex = position;
            animation.setFillAfter(true);
            animation.setDuration(300);
            cursor.startAnimation(animation);

        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    }

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    //设置动画图片宽度
    private void setBmpW(ImageView imageView, int mWidth) {
        ViewGroup.LayoutParams para;
        para = imageView.getLayoutParams();
        para.width = mWidth;
        imageView.setLayoutParams(para);
    }

    //顶部文字回复默认
    private void resetTextViewTextColor() {
        recommend_text.setTextColor(getResources().getColor(R.color.color_gray));
        food_text.setTextColor(getResources().getColor(R.color.color_gray));
        activity_text.setTextColor(getResources().getColor(R.color.color_gray));
        dress_text.setTextColor(getResources().getColor(R.color.color_gray));
        train_text.setTextColor(getResources().getColor(R.color.color_gray));
    }
}
