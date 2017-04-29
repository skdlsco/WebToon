package com.example.eka.webtoon;

import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;

import com.example.eka.webtoon.Adapter.PagerAdapter;
import com.example.eka.webtoon.Adapter.TopPagerAdapter;
import com.example.eka.webtoon.Thread.TopItemThread;


public class MainActivity extends AppCompatActivity {
    private TabLayout tablayout;
    private ViewPager viewPager;
    private ViewPager topViewPager;
    private PagerAdapter pagerAdapter;
    private TopPagerAdapter topPagerAdapter;
    private CustomIndicator customIndicator;
    static public Display display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topPagerAdapter = new TopPagerAdapter(getSupportFragmentManager());
        topViewPager = (ViewPager) findViewById(R.id.topviewpager);
        topViewPager.setAdapter(topPagerAdapter);
        customIndicator= (CustomIndicator) findViewById(R.id.cutomindicator);
        TopItemThread topItemThread = new TopItemThread();
        topItemThread.start();
        try {
            topItemThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        customIndicator.creatIndicator(topPagerAdapter.getCount(),30);
        topViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels){
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

        pagerAdapter =new PagerAdapter(getSupportFragmentManager(),tablayout.getTabCount());

        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));

        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tablayout.getSelectedTabPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
