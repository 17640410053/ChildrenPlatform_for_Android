package com.neusoft.yl.childrenplatform.Activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.neusoft.yl.childrenplatform.Bean.UpUserBean;
import com.neusoft.yl.childrenplatform.Listener.RetrofitListener;
import com.neusoft.yl.childrenplatform.Model.UserModel;
import com.neusoft.yl.childrenplatform.R;

public class UpdateUserIntroActivity extends BaseActivity implements RetrofitListener<UpUserBean>{

    private EditText edit_new_intro;
    private TextView residue_text;
    private Button back_btn;
    private String old_intro;

    @Override
    void initViews() {
        edit_new_intro = (EditText) findViewById(R.id.edit_new_intro);
        residue_text = (TextView) findViewById(R.id.residue_text);
        back_btn = (Button) findViewById(R.id.back_btn);
    }

    @Override
    public void initView() {

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.text_save:
                if (edit_new_intro.getText().toString().equals(old_intro)) {
                    finish();
                } else {
                    saveintro();
                }
                break;
        }
    }

    private void saveintro() {
        UserModel userModel = new UserModel();
        userModel.updateUserintro(getUser_id(), edit_new_intro.getText().toString(), this);
    }

    @Override
    void initEvents() {
    }

    @Override
    public void initData() {
    }

    @Override
    public void onSuccess(UpUserBean upUserBean, int flag) {
        if (upUserBean.getCode().equals("200")) {
            finish();
            showToast(upUserBean.getMessage());
        } else {
            showToast(upUserBean.getMessage());
        }
    }

    @Override
    public void onFail() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user_intro);
        initViews();
        old_intro = getIntent().getStringExtra("intro");
        edit_new_intro.setText(old_intro);
        edit_new_intro.setSelection(edit_new_intro.length());
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        edit_new_intro.addTextChangedListener(new TextWatcher() {
            int MaxNum = 70;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                int num = MaxNum - editable.length();
                residue_text.setText(String.valueOf(num));
            }
        });
    }
}
