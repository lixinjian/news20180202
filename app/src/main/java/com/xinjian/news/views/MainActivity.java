package com.xinjian.news.views;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.xinjian.news.R;
import com.xinjian.news.common.activity.BaseActivity;
import com.xinjian.news.common.adapter.ViewPagerFragmentAdapter;
import com.xinjian.news.common.widget.NoPreloadViewPager;
import com.xinjian.news.views.developer.DeveloperTabLayout;
import com.xinjian.news.views.hottopic.HotTopicTabLayout;
import com.xinjian.news.views.more.MoreTabLayout;
import com.xinjian.news.views.technology.TechnologyTabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private BottomNavigationView mBottomNavigationView;

    private boolean isFinish = false;//防止误触返回退出

    private NoPreloadViewPager mViewPager;

//    private DeveloperTabLayout mDeveloperTabLayout;
//    private HotTopicTabLayout mHotTopicTabLayout;
//    private MoreTabLayout mMoreTabLayout;
//    private TechnologyTabLayout mTechnologyTabLayout;

    private ViewPagerFragmentAdapter mViewPagerFragmentAdapter;

    private FragmentManager mFragmentManager;

    private List<Fragment> mFragmentList = new ArrayList<>();

    private MenuItem menuItem;

    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragmentManager = getSupportFragmentManager();
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mViewPager = findViewById(R.id.noPreloadViewPager);
        mBottomNavigationView = findViewById(R.id.bottom_navigation_view);
        navigationView = findViewById(R.id.main_navigationView);
        drawerLayout = findViewById(R.id.drawer_layout);
        mToolbar = findViewById(R.id.main_toolbar);
        mToolbar.setTitle("热门话题");

        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.menu);
        }

        initFragmentList();

        mViewPagerFragmentAdapter = new ViewPagerFragmentAdapter(mFragmentManager, mFragmentList);

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.menu_item_hot_topic:
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.menu_item_technology:
                        mViewPager.setCurrentItem(1);
                        break;
                    case R.id.menu_item_developer:
                        mViewPager.setCurrentItem(2);
                        break;
                    case R.id.menu_item_more:
                        mViewPager.setCurrentItem(3);
                        break;
                }
                return false;
            }
        });

        final String[] titleName = new String[]{
                "热门话题", "科技动态", "开发者咨询", "更多"
        };

        mViewPager.setOnPageChangeListener(new NoPreloadViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    mBottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                menuItem = mBottomNavigationView.getMenu().getItem(position);
                menuItem.setChecked(true);
                mToolbar.setTitle(titleName[position]);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mViewPager.setAdapter(mViewPagerFragmentAdapter);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    private void initFragmentList() {
        Fragment hotTopicTabLayout = new HotTopicTabLayout();
        Fragment technologyTabLayout = new TechnologyTabLayout();
        Fragment developerTabLayout = new DeveloperTabLayout();
        Fragment moreTabLayout = new MoreTabLayout();
        mFragmentList.add(hotTopicTabLayout);
        mFragmentList.add(technologyTabLayout);
        mFragmentList.add(developerTabLayout);
        mFragmentList.add(moreTabLayout);
    }

    /**
     * 对toolbar的操作.
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    /**
     * toolbar上边的菜单按钮点击
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public void onBackPressedSupport() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            pop();
        } else {
            if (isFinish) {
                finish();
            } else {
                isFinish = true;
                Toast.makeText(this, "再按一次返回键退出", Toast.LENGTH_SHORT).show();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        isFinish = false;
                    }
                }).start();
            }
        }
    }
}
