package com.xinjian.news.views.technology;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xinjian.news.R;


/**
 * Created by lxj on 2017/12/20 0020.
 * 科技动态
 */

public class TechnologyTabLayout extends Fragment {

    private static TechnologyTabLayout instance = null;

    public static TechnologyTabLayout getInstance() {
        if (instance == null) {
            instance = new TechnologyTabLayout();
        }
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.technology_tab, container, false);

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
