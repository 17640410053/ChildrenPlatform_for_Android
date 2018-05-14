package com.neusoft.yl.childrenplatform.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.neusoft.yl.childrenplatform.R;

/**
 * Created by Kirito on 2017/11/25.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected int layout_file = R.layout.activity_main;
    protected static String user_id;
    private Toast toast;
    abstract void initViews();
    abstract void initEvents();
    abstract void initData();
    void setLayout(int layout_file) {setContentView(layout_file);}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLayout(layout_file);
        initViews();
        initEvents();
        initData();
    }

    public static String getUser_id(){
        return user_id;
    }

    public static void setUser_id(String u_id){
        user_id = u_id;
    }

    public void showToast(String text) {
        if (toast == null) {
            toast = Toast.makeText(BaseActivity.this, text, Toast.LENGTH_SHORT);
        } else {
            toast.setText(text);
            toast.setDuration(Toast.LENGTH_SHORT);
        }
        toast.show();
    }

    public void cancelToast(){
        if (toast!= null){
            toast.cancel();
        }
    }

    public void onBackPressed(){
        cancelToast();
        super.onBackPressed();
    }
}
