package com.neusoft.yl.childrenplatform.Fragment.type_fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.neusoft.yl.childrenplatform.Fragment.type_fragment.recommend_fragment.CompFragment;
import com.neusoft.yl.childrenplatform.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecommendFragment extends Fragment {

    private RadioGroup radioGroup_recommend;

    private CompFragment compFragment;

    private FragmentTransaction transaction;
    private FragmentManager fragmentManager;

    private void replace(Fragment fragment){
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.recommend_fragment,fragment);
        transaction.commit();
    }

    public RecommendFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        fragmentManager = getChildFragmentManager();
        radioGroup_recommend = (RadioGroup) view.findViewById(R.id.radioGroup_recommend);
        radioGroup_recommend.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.radio_comp:
                        compFragment = new CompFragment();
                        replace(compFragment);
                }
            }
        });
        radioGroup_recommend.check(R.id.radio_comp);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recommend, container, false);
    }

}
