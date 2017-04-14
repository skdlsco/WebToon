package com.example.eka.webtoon.Thread;

import com.example.eka.webtoon.Item;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by eka on 2017. 4. 14..
 */

public class ItemThread extends Thread {
    ArrayList<Item> items = new ArrayList<>();
    String url;
    Document doc;
    Elements col_selected;
    Elements links;
    public ItemThread (String url){
        this.url=url;
    }
    @Override
    public void run() {
        try {
            doc = Jsoup.connect("http://"+url).get();
            col_selected = doc.select(".img_list").select("li");
            links = col_selected.select(".thumb");

        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Element element : col_selected){
            items.add( new Item( element.select("a").attr("title") , element.select("a").select("img").attr("src") , element.select(".desc").text()));
        }
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
