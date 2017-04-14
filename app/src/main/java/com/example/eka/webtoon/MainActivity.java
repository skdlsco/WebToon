package com.example.eka.webtoon;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private MyAdapter adapter;
    private ArrayList<Item> items = new ArrayList<>();
    private GridView gridView;
    private Document doc;
    private Elements col_selected;
    private Elements links;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Thread thread = new Thread() {

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

        };
        thread.start();
        try {
            thread.join();
            gridView = (GridView) findViewById(R.id.gridview);
            adapter = new MyAdapter(items,this);
            gridView.setAdapter(adapter);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
