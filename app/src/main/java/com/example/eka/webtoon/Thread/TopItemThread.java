package com.example.eka.webtoon.Thread;

import android.util.Log;

import com.example.eka.webtoon.TopItem;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by eka on 2017. 4. 16..
 */

public class TopItemThread extends Thread {

    private String image_url;
    private String toon_name;
    private String toon_artist;
    private String toon_contents;

    static private ArrayList<TopItem> items = new ArrayList<>();

    Document doc;
    @Override
    public void run() {
        super.run();

        try {
            doc= Jsoup.connect("https://comic.naver.com/webtoon/weekday.nhn").get();
            Elements webtoon_spot = doc.select(".webtoon_spot2").select("li");
            for(Element element: webtoon_spot){
                image_url = element.select("a").select("img").attr("src");
                toon_name = element.select("strong").text();
                toon_artist = element.select("a").next("p").text();
                toon_contents = element.select("p").next().text();
                items.add(new TopItem(image_url,toon_name,toon_artist,toon_contents));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<TopItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<TopItem> items) {
        this.items = items;
    }
}
