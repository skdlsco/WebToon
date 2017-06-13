package com.example.eka.webtoon.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.eka.webtoon.fragment.fragment_friday;
import com.example.eka.webtoon.fragment.fragment_monday;
import com.example.eka.webtoon.fragment.fragment_saturday;
import com.example.eka.webtoon.fragment.fragment_sunday;
import com.example.eka.webtoon.fragment.fragment_tuesday;
import com.example.eka.webtoon.fragment.fragment_wednesday;
import com.example.eka.webtoon.fragment.fragmetn_thursday;


/**
 * Created by eka on 2017. 4. 15..
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    private int tabCount;
    int height;

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public PagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new fragment_monday();
            case 1:
                return new fragment_tuesday();
            case 2:
                return new fragment_wednesday();
            case 3:
                return new fragmetn_thursday();
            case 4:
                return new fragment_friday();
            case 5:
                return new fragment_saturday();
            case 6:
                return new fragment_sunday();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 7;
    }

    public int getHeight() {
        return height;
    }
}
