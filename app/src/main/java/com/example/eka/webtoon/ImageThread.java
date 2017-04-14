package com.example.eka.webtoon;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by eka on 2017. 4. 14..
 */

public class ImageThread extends Thread {
    String _url;
    URL url;
    Bitmap bitmap=null;

    public ImageThread(String _url) {
        this._url = _url;
    }

    @Override
    public void run() {
        super.run();

        try {

            url = new URL(_url);
            HttpURLConnection urlcon= (HttpURLConnection) url.openConnection();
            urlcon.setDoInput(true);
            urlcon.connect();

            InputStream is = urlcon.getInputStream();
            bitmap = BitmapFactory.decodeStream(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
