package com.neusoft.yl.childrenplatform.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.neusoft.yl.childrenplatform.Bean.RegisterBean;
import com.neusoft.yl.childrenplatform.Listener.RetrofitListener;
import com.neusoft.yl.childrenplatform.Model.UserModel;
import com.neusoft.yl.childrenplatform.R;

public class RegisterActivity extends BaseActivity implements RetrofitListener<RegisterBean>{

    private EditText text_telephone,text_password,re_password;
    private Button register_btn,back_btn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initViews();
        initEvents();
    }

    @Override
    void initViews() {
        setLayout(R.layout.activity_register);
        text_telephone = (EditText) findViewById(R.id.text_telephone);
        text_password = (EditText) findViewById(R.id.text_password);
        re_password = (EditText) findViewById(R.id.re_password);
        register_btn = (Button) findViewById(R.id.register_btn);
        back_btn = (Button) findViewById(R.id.back_btn);
    }

    @Override
    void initEvents() {
        text_telephone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (TextUtils.isEmpty(text_telephone.getText()) || TextUtils.isEmpty(text_password.getText()) || TextUtils.isEmpty(re_password.getText())){
                    //如果为空注册按钮不可选
                    register_btn.setEnabled(false);
                    register_btn.setBackgroundResource(R.drawable.shape_login_btn_false);
                }else {
                    //否者可选
                    register_btn.setEnabled(true);
                    register_btn.setBackgroundResource(R.drawable.select_login_btn);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        text_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (TextUtils.isEmpty(text_telephone.getText()) || TextUtils.isEmpty(text_password.getText()) || TextUtils.isEmpty(re_password.getText())){
                    //如果为空登录按钮不可选
                    register_btn.setEnabled(false);
                    register_btn.setBackgroundResource(R.drawable.shape_login_btn_false);
                }else {
                    //否者可选
                    register_btn.setEnabled(true);
                    register_btn.setBackgroundResource(R.drawable.select_login_btn);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        re_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (TextUtils.isEmpty(text_telephone.getText()) || TextUtils.isEmpty(text_password.getText()) || TextUtils.isEmpty(re_password.getText())){
                    //如果为空登录按钮不可选
                    register_btn.setEnabled(false);
                    register_btn.setBackgroundResource(R.drawable.shape_login_btn_false);
                }else {
                    //否者可选
                    register_btn.setEnabled(true);
                    register_btn.setBackgroundResource(R.drawable.select_login_btn);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });


        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (text_telephone.length() == 11){
                    if (text_password.getText().toString().equals(re_password.getText().toString())){
                        register();
                    }else {
                        showToast("请确认两次密码相同");
                    }
                }else {
                    showToast("请输入正确的手机号");
                }
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

    }

    @Override
    public void onSuccess(RegisterBean registerBean, int flag) {
        if (registerBean.getCode().equals("200")){
            Intent intent = new Intent();
            intent.putExtra("telephone",text_telephone.getText().toString());
            intent.putExtra("password",text_password.getText().toString());
            setResult(RESULT_OK,intent);
            finish();
            showToast(registerBean.getMessage());
        }else {
            showToast(registerBean.getMessage());
        }
    }

    @Override
    public void onFail() {
        showToast("网络错误");
    }

    private void register(){
        UserModel userModel = new UserModel();
        userModel.userRegister(text_telephone.getText().toString().trim(),text_password.getText().toString().trim(),this);
    }

}
