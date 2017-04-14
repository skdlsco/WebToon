package com.example.eka.webtoon;

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
    Document doc;
    Elements col_selected;
    Elements links;
    @Override
    public void run() {
        try {
            doc = Jsoup.connect("http://comic.naver.com/webtoon/weekday.nhn").get();
            col_selected = doc.select(".col_selected").select("li");
            links = col_selected.select(".thumb");

        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Element element : col_selected){
            items.add( new Item(element.select("a").attr("title") , element.select("a").select("img").attr("src")));
        }
    }

}
