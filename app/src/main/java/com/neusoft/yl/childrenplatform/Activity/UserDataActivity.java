package com.neusoft.yl.childrenplatform.Activity;

import android.app.AlertDialog;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.neusoft.yl.childrenplatform.Const;
import com.neusoft.yl.childrenplatform.Fragment.dialog_fragment.SexDialogFragment;
import com.neusoft.yl.childrenplatform.R;
import com.squareup.picasso.Picasso;

public class UserDataActivity extends BaseActivity implements SexDialogFragment.SexDialogListener {

    private Button back_btn;
    private TextView user_name, user_uid, user_sex, user_address;
    private RoundedImageView user_header;

    private SharedPreferences sharedPreferences;
    private String filename = "cpform";
    private int MODE = MODE_PRIVATE;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);
        initViews();
        Picasso.with(this).load(Const.PIC_URL + "user_image/" + getIntent().getStringExtra("pic")).into(user_header);
        user_name.setText(getIntent().getStringExtra("username"));
        if (getIntent().getStringExtra("sex") == null) {
            user_sex.setText("保密");
        } else if (getIntent().getStringExtra("sex").equals("3")) {
            user_sex.setText("保密");
        } else {
            if (getIntent().getStringExtra("sex").equals("0")) {
                user_sex.setText("女");
            } else {
                user_sex.setText("男");
            }
        }

        user_uid.setText(getIntent().getStringExtra("uid"));
        user_address.setText(getIntent().getStringExtra("address"));

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    void initViews() {
        back_btn =  findViewById(R.id.back_btn);
        user_name =  findViewById(R.id.user_name);
        user_uid =  findViewById(R.id.user_uid);
        user_sex =  findViewById(R.id.user_sex);
        user_address =  findViewById(R.id.user_address);
        user_header =  findViewById(R.id.user_header);
        sharedPreferences = getSharedPreferences(filename, MODE);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.header_layout:
                showToast("修改头像");
                break;
            case R.id.username_layout:
                Intent intent_username = new Intent(UserDataActivity.this, UpdateUserNameActivity.class);
                startActivityForResult(intent_username, 356);
                break;
            case R.id.uid_layout:
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                clipboardManager.setText(user_uid.getText());
                showToast("UID号已复制到剪贴板");
                break;
            case R.id.sex_layout:
                SexDialogFragment sexDialogFragment = new SexDialogFragment();
                sexDialogFragment.show(getSupportFragmentManager(), "sexDialogFragment");
                break;
            case R.id.address_layout:
                showToast("修改地址");
                break;
            case R.id.intro_layout:
                Intent intent_intro = new Intent(UserDataActivity.this, UpdateUserIntroActivity.class);
                intent_intro.putExtra("intro", getIntent().getStringExtra("intro"));
                startActivityForResult(intent_intro, 357);
                break;
            case R.id.logout_layout:
                AlertDialog alertDialog = new AlertDialog.Builder(UserDataActivity.this).setMessage("乃确定不是手滑了么？")
                        .setPositiveButton("注销", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.clear();
                                editor.commit();
                                user_id = "-1";
                                finish();
                            }
                        }).setNegativeButton("我手滑了", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                }).show();
                alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.color_pink));
                alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE).setTextColor(getResources().getColor(R.color.color_pink));
                break;
        }
    }

    @Override
    public void getDataFrom_SexDialogListener(String sex) {
        if (sex.equals("3")) {
            user_sex.setText("保密");
        } else {
            if (sex.equals("0")) {
                user_sex.setText("女");
            } else {
                user_sex.setText("男");
            }
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 356) {
            switch (resultCode) {
                case RESULT_OK:
                    user_name.setText(data.getStringExtra("username"));
                    break;
                case RESULT_CANCELED:
                    break;
            }
        }
    }

    @Override
    void initEvents() {
    }

    @Override
    void initData() {

    }
}
