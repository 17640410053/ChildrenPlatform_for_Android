package com.neusoft.yl.childrenplatform.Fragment;

import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.neusoft.yl.childrenplatform.Activity.BaseActivity;

/**
 * Created by Kirito on 2017/11/27.
 */

public class BaseFragment extends Fragment {
    private Toast toast;
    public String getUserId(){
        return BaseActivity.getUser_id();
    }
    public void setUserId(String userId){
        BaseActivity.setUser_id(userId);
    }
}
