package com.neusoft.yl.childrenplatform.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.neusoft.yl.childrenplatform.Bean.LoginBean;
import com.neusoft.yl.childrenplatform.Listener.RetrofitListener;
import com.neusoft.yl.childrenplatform.Model.UserModel;
import com.neusoft.yl.childrenplatform.R;

import static android.widget.Toast.makeText;

public class LoginActivity extends BaseActivity implements RetrofitListener<LoginBean>{

    private EditText telephone,password;
    private Button back_btn,login_btn,reg_btn;

    //存储用户ID
    private SharedPreferences sharedPreferences;
    private String filename = "cpform";
    private int MODE = MODE_PRIVATE;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sharedPreferences = getSharedPreferences(filename,MODE);
        telephone = (EditText) findViewById(R.id.telephone);
        password = (EditText) findViewById(R.id.password);
        login_btn = (Button) findViewById(R.id.login_btn);
        reg_btn = (Button) findViewById(R.id.reg_btn);
        back_btn = (Button) findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //监听手机号输入是否为空
        telephone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (TextUtils.isEmpty(telephone.getText()) || TextUtils.isEmpty(password.getText())){
                    //如果为空登录按钮不可选
                    login_btn.setEnabled(false);
                    login_btn.setBackgroundResource(R.drawable.shape_login_btn_false);
                }else {
                    //否者可选
                    login_btn.setEnabled(true);
                    login_btn.setBackgroundResource(R.drawable.select_login_btn);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        //监听密码输入是否为空
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (TextUtils.isEmpty(telephone.getText()) || TextUtils.isEmpty(password.getText())){
                    //如果为空登录按钮不可选
                    login_btn.setEnabled(false);
                    login_btn.setBackgroundResource(R.drawable.shape_login_btn_false);
                }else {
                    //否者可选
                    login_btn.setEnabled(true);
                    login_btn.setBackgroundResource(R.drawable.select_login_btn);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivityForResult(intent,110);
            }
        });

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (telephone.getText().toString().equals("")||password.getText().toString().equals("")){
                    makeText(LoginActivity.this,"用户名和密码不能为空", Toast.LENGTH_SHORT).show();
                }
                else {
                    login();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 110){
            switch (resultCode){
                case RESULT_OK:
                    telephone.setText(data.getStringExtra("telephone"));
                    password.setText(data.getStringExtra("password"));
                    break;
                case RESULT_CANCELED:
                    break;
            }
        }
    }

    private void login() {
        UserModel userModel = new UserModel();
        userModel.userLogin(telephone.getText().toString().trim(),password.getText().toString().trim(),this);
    }

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

    }

    @Override
    public void onSuccess(LoginBean loginBean, int flag) {
        if (loginBean.getCode().equals("200")){
            showToast(loginBean.getMessage());
            saveUserId(loginBean.getData().getUser_id(),loginBean.getData().getEmail(),loginBean.getData().getUsername(),loginBean.getData().getImage());
            setUser_id(loginBean.getData().getUser_id());
            Intent data = new Intent();
            data.putExtra("email",loginBean.getData().getEmail());
            data.putExtra("username",loginBean.getData().getUsername());
            data.putExtra("user_pic",loginBean.getData().getImage());
            setResult(RESULT_OK,data);
            finish();
        }else {
            showToast(loginBean.getMessage());
        }
    }

    @Override
    public void onFail() {
        showToast("网络错误");
    }

    public void saveUserId(String userId,String email,String username,String user_pic){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("userID",userId);
        editor.putString("email",email);
        editor.putString("username",username);
        editor.putString("user_pic",user_pic);
        editor.commit();
    }
}
