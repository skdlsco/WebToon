package com.example.eka.webtoon;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.eka.webtoon.Adapter.PagerAdapter;


public class MainActivity extends AppCompatActivity {
    private TabLayout tablayout;
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    }
}
