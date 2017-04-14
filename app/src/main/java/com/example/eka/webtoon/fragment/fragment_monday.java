package com.example.eka.webtoon.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import com.example.eka.webtoon.Adapter.ListAdapter;
import com.example.eka.webtoon.Item;
import com.example.eka.webtoon.R;
import com.example.eka.webtoon.Thread.ItemThread;

import java.util.ArrayList;


public class fragment_monday extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_monday,null);

        String url="comic.naver.com/webtoon/weekdayList.nhn?week=mon";

        ItemThread itemThread = new ItemThread(url);

        ArrayList<Item> items= new ArrayList<>();
        GridView listView = (GridView) view.findViewById(R.id.listmonday);
        ListAdapter listAdapter;


        itemThread.start();
        try {
            items= itemThread.getItems();
            listAdapter = new ListAdapter(items,getContext());
            listView.setAdapter(listAdapter);
            itemThread.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        return view;
    }
}