package com.xinjian.news.views.developer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xinjian.news.R;
import com.xinjian.news.common.fragment.BaseFragment;


/**
 * Created by lxj on 2017/12/20 0020.
 * 开发者咨询
 */

public class DeveloperTabLayout extends BaseFragment {

    private static DeveloperTabLayout instance = null;

    public static DeveloperTabLayout getInstance() {
        if (instance == null) {
            instance = new DeveloperTabLayout();
        }
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.developer_tab, container, false);



        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
