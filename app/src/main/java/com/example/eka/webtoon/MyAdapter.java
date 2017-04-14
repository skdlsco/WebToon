package com.example.eka.webtoon;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by eka on 2017. 4. 14..
 */

public class MyAdapter extends BaseAdapter {
    ArrayList<Item> items;
    Context context;
    Bitmap bitmap;

    public MyAdapter(ArrayList<Item> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.web_toon_list,null);

        TextView toon_name = (TextView) view.findViewById(R.id.toon_name);
        ImageView image= (ImageView) view.findViewById(R.id.toon_img);

        ImageThread imageThread = new ImageThread(items.get(position).getImage_url());

        imageThread.start();
        try {
            imageThread.join();
            image.setImageBitmap(imageThread.getBitmap());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        toon_name.setText(items.get(position).getToon_name());

        return view;
    }
}
