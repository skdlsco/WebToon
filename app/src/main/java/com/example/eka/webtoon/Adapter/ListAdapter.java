package com.example.eka.webtoon.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eka.webtoon.Item;
import com.example.eka.webtoon.R;
import com.example.eka.webtoon.Thread.ImageThread;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by eka on 2017. 4. 15..
 */

public class ListAdapter extends BaseAdapter {
    ArrayList<Item> items;
    Context context;
    Bitmap bitmap;

    public ListAdapter(ArrayList<Item> items, Context context) {
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
        TextView toon_artist = (TextView) view.findViewById(R.id.toon_artist);
        ImageView image= (ImageView) view.findViewById(R.id.toon_img);

        ImageThread imageThread = new ImageThread(items.get(position).getImage_url());

        imageThread.start();
        try {
            imageThread.join();
            image.setImageBitmap(imageThread.getBitmap());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        toon_artist.setText(items.get(position).getToon_artist());
        toon_name.setText(items.get(position).getToon_name());

        return view;
    }
}
