package com.neusoft.yl.childrenplatform.Fragment.userfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.neusoft.yl.childrenplatform.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserCollectFragment extends Fragment {


    public UserCollectFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_collect, container, false);
    }

}
