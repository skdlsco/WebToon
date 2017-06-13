package com.example.eka.webtoon.Adapter;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.eka.webtoon.Item;
import com.example.eka.webtoon.MainActivity;
import com.example.eka.webtoon.R;
import com.example.eka.webtoon.Thread.ImageThread;

import java.util.ArrayList;

import static android.content.Intent.ACTION_VIEW;
import static android.content.Intent.makeMainActivity;
import static android.content.Intent.makeRestartActivityTask;

/**
 * Created by eka on 2017. 6. 13..
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    ArrayList<Item> items = new ArrayList<>();
    Context context;

    public RecyclerViewAdapter(ArrayList<Item> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.web_toon_list, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        ImageThread imageThread = new ImageThread(items.get(position).getImage_url());
        imageThread.start();
        try {
            imageThread.join();
            Bitmap bitmap;
            bitmap = imageThread.getBitmap();
            if (bitmap != null) {
                holder.image.setImageBitmap(bitmap);

            } else {
                holder.image.setImageResource(R.drawable.menu_webtoon_noclick);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        holder.toon_artist.setText(items.get(position).getToon_artist());
        holder.toon_name.setText(items.get(position).getToon_name());
        holder.list_item.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(ACTION_VIEW, Uri.parse(items.get(position).getAddress()));
                context.startActivity(intent);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView toon_name;
        TextView toon_artist;
        ImageView image;
        LinearLayout list_item;

        public MyViewHolder(View itemView) {
            super(itemView);
            toon_name = (TextView) itemView.findViewById(R.id.toon_name);
            toon_artist = (TextView) itemView.findViewById(R.id.toon_artist);
            image = (ImageView) itemView.findViewById(R.id.toon_img);
            list_item = (LinearLayout) itemView.findViewById(R.id.list_item);
        }
    }
}
