package com.example.eka.webtoon;

import android.media.Image;

/**
 * Created by eka on 2017. 4. 14..
 */

public class Item {
    String toon_name;
    String image_url;
    String toon_artist;
    String address;

    public Item(String adrress, String toon_name, String image_url, String toon_artist) {
        this.toon_name = toon_name;
        this.image_url = image_url;
        this.toon_artist = toon_artist;
        this.address = adrress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getToon_artist() {
        return toon_artist;
    }

    public void setToon_artist(String toon_artist) {
        this.toon_artist = toon_artist;
    }
}
