package com.example.eka.webtoon.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.eka.webtoon.Adapter.RecyclerViewAdapter;
import com.example.eka.webtoon.Item;
import com.example.eka.webtoon.R;
import com.example.eka.webtoon.Thread.ItemThread;

import java.util.ArrayList;


public class fragment_monday extends Fragment {
    ArrayList<Item> items = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_monday, null);

        String url = "comic.naver.com/webtoon/weekdayList.nhn?week=mon";

        ItemThread itemThread = new ItemThread(url);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.listmonday);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        RecyclerViewAdapter recyclerViewAdapter;
        itemThread.start();
        try {
            itemThread.join();
            items = itemThread.getItems();
            recyclerViewAdapter = new RecyclerViewAdapter(items, getContext());
            recyclerView.setAdapter(recyclerViewAdapter);
            recyclerViewAdapter.notifyDataSetChanged();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return view;
    }
}