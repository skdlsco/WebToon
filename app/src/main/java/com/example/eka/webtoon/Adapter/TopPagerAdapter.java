package com.example.eka.webtoon.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.eka.webtoon.fragment.fragment_top;


public class TopPagerAdapter extends FragmentStatePagerAdapter {

    fragment_top fragment_1 = new fragment_top(0);
    fragment_top fragment_2 = new fragment_top(1);
    fragment_top fragment_3 = new fragment_top(2);

    public TopPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return fragment_1;
            case 1:
                return fragment_2;
            case 2:
                return fragment_3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
