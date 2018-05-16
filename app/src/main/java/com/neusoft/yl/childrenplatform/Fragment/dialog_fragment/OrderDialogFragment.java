package com.neusoft.yl.childrenplatform.Fragment.dialog_fragment;


import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.neusoft.yl.childrenplatform.Bean.CheckBean;
import com.neusoft.yl.childrenplatform.Listener.RetrofitListener;
import com.neusoft.yl.childrenplatform.Model.CompModel;
import com.neusoft.yl.childrenplatform.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderDialogFragment extends DialogFragment implements RetrofitListener<CheckBean> {

    private TextView edit_telephone, edit_address, edit_number;
    private Button checkout;

    public OrderDialogFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        edit_address = view.findViewById(R.id.edit_address);
        edit_number = view.findViewById(R.id.edit_number);
        edit_telephone = view.findViewById(R.id.edit_telephone);
        checkout = view.findViewById(R.id.checkout);

        Toast.makeText(getActivity(), getArguments().getString("user_id"), Toast.LENGTH_SHORT).show();
        edit_telephone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (TextUtils.isEmpty(edit_telephone.getText()) || TextUtils.isEmpty(edit_number.getText()) || TextUtils.isEmpty(edit_address.getText())) {
                    checkout.setEnabled(false);
                    checkout.setBackgroundResource(R.drawable.shape_login_btn_false);
                } else {
                    checkout.setEnabled(true);
                    checkout.setBackgroundResource(R.drawable.select_login_btn);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        edit_number.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (TextUtils.isEmpty(edit_telephone.getText()) || TextUtils.isEmpty(edit_number.getText()) || TextUtils.isEmpty(edit_address.getText())) {
                    checkout.setEnabled(false);
                    checkout.setBackgroundResource(R.drawable.shape_login_btn_false);
                } else {
                    checkout.setEnabled(true);
                    checkout.setBackgroundResource(R.drawable.select_login_btn);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        edit_address.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (TextUtils.isEmpty(edit_telephone.getText()) || TextUtils.isEmpty(edit_number.getText()) || TextUtils.isEmpty(edit_address.getText())) {
                    checkout.setEnabled(false);
                    checkout.setBackgroundResource(R.drawable.shape_login_btn_false);
                } else {
                    checkout.setEnabled(true);
                    checkout.setBackgroundResource(R.drawable.select_login_btn);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initData();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order_dialog, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            dialog.getWindow().setLayout((int) (displayMetrics.widthPixels * 0.8), ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }

    @Override
    public void initView() {

    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void initData() {
        CompModel compModel = new CompModel();
        compModel.upOrder(getArguments().getString("commodity_id"),
                getArguments().getString("user_id"),
                edit_address.getText().toString().trim(),
                edit_telephone.getText().toString().trim(),
                edit_number.getText().toString().trim(), this);
    }

    @Override
    public void onSuccess(CheckBean checkBean, int flag) {
        if (checkBean.getCode().equals("200")){
            Toast.makeText(getActivity(), checkBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFail() {
        Toast.makeText(getActivity(), "请检查你的网络！", Toast.LENGTH_SHORT).show();
    }
}
