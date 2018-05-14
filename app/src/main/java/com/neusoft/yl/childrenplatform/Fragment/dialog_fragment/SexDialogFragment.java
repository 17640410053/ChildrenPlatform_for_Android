package com.neusoft.yl.childrenplatform.Fragment.dialog_fragment;


import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.neusoft.yl.childrenplatform.Bean.UpUserBean;
import com.neusoft.yl.childrenplatform.Fragment.BaseFragment;
import com.neusoft.yl.childrenplatform.Listener.RetrofitListener;
import com.neusoft.yl.childrenplatform.Model.UserModel;
import com.neusoft.yl.childrenplatform.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SexDialogFragment extends DialogFragment implements RetrofitListener<UpUserBean>{

    private RadioGroup radioGroup_gender;
    private TextView sex_save;
    private String sex_select = "3";
    private BaseFragment baseFragment;

    public SexDialogFragment() {
        // Required empty public constructor
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

    public interface SexDialogListener{
        void getDataFrom_SexDialogListener(String sex);
    }

    @Override
    public void onSuccess(UpUserBean upUserBean, int flag) {
        if (upUserBean.getCode().equals("200")){
            SexDialogListener sexDialogListener = (SexDialogListener) getActivity();
            sexDialogListener.getDataFrom_SexDialogListener(sex_select);
            Toast.makeText(getActivity(), upUserBean.getMessage(), Toast.LENGTH_SHORT).show();
            dismiss();
        }else {
            Toast.makeText(getActivity(), upUserBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFail() {
        Toast.makeText(getActivity(),"网络错误", Toast.LENGTH_SHORT).show();
    }

    private void save_sex(){
        UserModel userModel = new UserModel();
        baseFragment = new BaseFragment();
        userModel.updateUserSex(baseFragment.getUserId(),sex_select,this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_sex_dialog,null);
        radioGroup_gender = (RadioGroup) view.findViewById(R.id.radioGroup_gender);
        sex_save = (TextView) view.findViewById(R.id.sex_save);
        radioGroup_gender.check(R.id.radio_gender);
        radioGroup_gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.radio_male:
                        sex_select = "1";
                        break;
                    case R.id.radio_gender:
                        sex_select = "3";
                        break;
                    case R.id.radio_female:
                        sex_select = "0";
                        break;
                }
            }
        });
        sex_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save_sex();
            }
        });
        builder.setView(view);
        return builder.create();
    }
}
