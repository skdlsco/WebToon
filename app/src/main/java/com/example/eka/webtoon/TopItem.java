package com.example.eka.webtoon;

/**
 * Created by eka on 2017. 4. 16..
 */

public class TopItem {

    private String image_url;
    private String toon_name;
    private String toon_artist;
    private String toon_contents;

    public TopItem(String image_url, String toon_name, String toon_artist, String toon_contents) {
        this.image_url = image_url;
        this.toon_name = toon_name;
        this.toon_artist = toon_artist;
        this.toon_contents = toon_contents;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getToon_name() {
        return toon_name;
    }

    public void setToon_name(String toon_name) {
        this.toon_name = toon_name;
    }

    public String getToon_artist() {
        return toon_artist;
    }

    public void setToon_artist(String toon_artist) {
        this.toon_artist = toon_artist;
    }

    public String getToon_contents() {
        return toon_contents;
    }

    public void setToon_contents(String toon_contents) {
        this.toon_contents = toon_contents;
    }
}
