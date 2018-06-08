package com.music.agnes.mymusicmatcher;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class MusicSelectorActivity extends Activity {
    private TextView mTypeTextView;
    private ListView mListView;
    private String[] genres = new String[] {"Rock", "Country",
            "Jazz", "Pop", "Classic", "Oprah",
            "Africa", "Afrobeat", "Asia", "Zydeco",
            "Ragge", "House", "Hip-Hope",
            "Dancehall", "Rnb's"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_selector);

        mListView = (ListView) findViewById(R.id.listView);
        mTypeTextView = (TextView) findViewById(R.id.typeTextView);


        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, genres);
        mListView.setAdapter(adapter);




        Intent intent = getIntent();
        String type = intent.getStringExtra("type");
        mTypeTextView.setText("Here are all the music genres list: " + type);
    }
}