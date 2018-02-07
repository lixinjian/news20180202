package com.xinjian.news.views.hottopic;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xinjian.news.R;


/**
 * Created by lxj on 2017/12/20 0020.
 * 热门话题
 */

public class HotTopicTabLayout extends Fragment {

    private static HotTopicTabLayout instance = null;

    public static HotTopicTabLayout getInstance() {
        if (instance == null) {
            instance = new HotTopicTabLayout();
        }
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hot_topic_tab, container, false);

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
