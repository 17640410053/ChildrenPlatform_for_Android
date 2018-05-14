package com.neusoft.yl.childrenplatform.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.neusoft.yl.childrenplatform.Bean.UpUserBean;
import com.neusoft.yl.childrenplatform.Listener.RetrofitListener;
import com.neusoft.yl.childrenplatform.Model.UserModel;
import com.neusoft.yl.childrenplatform.R;

public class UpdateUserNameActivity extends BaseActivity implements RetrofitListener<UpUserBean>{

    private EditText edit_new_username;
    private Button back_btn;

    @Override
    void initViews() {
        edit_new_username = (EditText) findViewById(R.id.edit_new_username);
        back_btn = (Button) findViewById(R.id.back_btn);
    }

    @Override
    void initEvents() {
    }

    @Override
    public void initData() {

    }


    @Override
    public void onSuccess(UpUserBean upUserBean, int flag) {
        if (upUserBean.getCode().equals("200")){
            Intent data = new Intent();
            data.putExtra("username",edit_new_username.getText().toString());
            setResult(RESULT_OK,data);
            showToast(upUserBean.getMessage());
            finish();
        }else {
            showToast(upUserBean.getMessage());
        }
    }

    @Override
    public void onFail() {
        showToast("请检查你的网络╮(╯▽╰)╭");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user_name);
        initViews();

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void initView() {

    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.text_save:
                if (edit_new_username.length() < 4){
                    showToast("昵称太短啦(´・ω・`)");
                }else if (edit_new_username.length() > 14){
                    showToast("昵称太长啦 (。-`ω´-)");
                }else {
                    savename();
                }
                break;
        }
    }

    private void savename() {
        UserModel userModel = new UserModel();
        userModel.updateUsername(getUser_id(),edit_new_username.getText().toString(),this);
    }
}
