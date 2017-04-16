package com.example.eka.webtoon.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eka.webtoon.R;
import com.example.eka.webtoon.Thread.ImageThread;
import com.example.eka.webtoon.Thread.TopItemThread;
import com.example.eka.webtoon.TopItem;

/**
 * Created by eka on 2017. 4. 16..
 */

public class fragment_top extends Fragment{
    int num;
    Display display;
    public fragment_top(int num) {
        this.num=num;
    }
    TopItem item;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_top,null);

        ImageView top_img= (ImageView) view.findViewById(R.id.top_img);
        TextView top_name = (TextView) view.findViewById(R.id.top_name);
        TextView top_artist = (TextView) view.findViewById(R.id.top_artist);
        TextView top_contents= (TextView) view.findViewById(R.id.top_contents);

        item = TopItemThread.getItems().get(num);

        ImageThread imageThread = new ImageThread(item.getImage_url());
        imageThread.start();
        try {
            imageThread.join();
            Bitmap bitmap=imageThread.getBitmap();
            display = getActivity().getWindowManager().getDefaultDisplay();
            DisplayMetrics realMetrics=new DisplayMetrics();
            display.getRealMetrics(realMetrics);
            bitmap = Bitmap.createScaledBitmap(bitmap,realMetrics.widthPixels, (int) (realMetrics.heightPixels*0.3),true);
            top_img.setImageBitmap(bitmap);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        top_name.setText(item.getToon_name());
        top_artist.setText(item.getToon_artist());
        top_contents.setText(item.getToon_contents());

        return view;
    }
}
