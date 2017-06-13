package com.example.eka.webtoon;

import android.app.ActionBar;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TabHost;

import com.example.eka.webtoon.Adapter.PagerAdapter;
import com.example.eka.webtoon.Adapter.TopPagerAdapter;
import com.example.eka.webtoon.Thread.TopItemThread;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TabLayout tablayout;
    private ViewPager viewPager;
    private ViewPager topViewPager;
    private PagerAdapter pagerAdapter;
    private TopPagerAdapter topPagerAdapter;
    private CustomIndicator customIndicator;
    private NestedScrollView scrollView;
    static public Display display;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollView = (NestedScrollView) findViewById(R.id.scrollView);
        topPagerAdapter = new TopPagerAdapter(getSupportFragmentManager());
        topViewPager = (ViewPager) findViewById(R.id.topviewpager);
        topViewPager.setAdapter(topPagerAdapter);
        customIndicator = (CustomIndicator) findViewById(R.id.cutomindicator);
        TopItemThread topItemThread = new TopItemThread();
        topItemThread.start();
        try {
            topItemThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        customIndicator.creatIndicator(topPagerAdapter.getCount(), 15);
        topViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                customIndicator.select(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        display = getWindowManager().getDefaultDisplay();
        tablayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        tablayout.addTab(tablayout.newTab().setText("월"));
        tablayout.addTab(tablayout.newTab().setText("화"));
        tablayout.addTab(tablayout.newTab().setText("수"));
        tablayout.addTab(tablayout.newTab().setText("목"));
        tablayout.addTab(tablayout.newTab().setText("금"));
        tablayout.addTab(tablayout.newTab().setText("토"));
        tablayout.addTab(tablayout.newTab().setText("일"));

        tablayout.setTabGravity(TabLayout.GRAVITY_FILL);
        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), tablayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));
        tablayout.setSelectedTabIndicatorColor(0x00000000);
        tablayout.setTabTextColors(0xff000000, 0xffffffff);
        tablayout.setBackgroundResource(R.drawable.tab_select);
        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewPager.setCurrentItem(tablayout.getSelectedTabPosition(), true);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {


            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        Runnable r = new Runnable() {
            @Override
            public void run() {

            }
        };
        final Handler handler = new Handler();
        Timer timer = new Timer();

        final int[] top_pager_position = {0};
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                top_pager_position[0]++;
                if (top_pager_position[0] == 3)
                    top_pager_position[0] = 0;
                topViewPager.setCurrentItem(top_pager_position[0], true);
            }
        };

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        }, 3000, 3000);
    }

    @Override
    public void onClick(View v) {
        
    }
}
