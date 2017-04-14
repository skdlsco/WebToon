package com.example.eka.webtoon;

import android.media.Image;

/**
 * Created by eka on 2017. 4. 14..
 */

public class Item {
    String toon_name;
    String image_url;

    public Item(String toon_name, String image_url) {
        this.toon_name = toon_name;
        this.image_url = image_url;
    }

    public String getToon_name() {
        return toon_name;
    }

    public void setToon_name(String toon_name) {
        this.toon_name = toon_name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
