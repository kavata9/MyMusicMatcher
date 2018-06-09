package com.music.agnes.mymusicmatcher;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MusicSelectorActivity extends Activity {
    @BindView(R.id.typeTextView) TextView mTypeTextView;
    @BindView(R.id.listView) ListView mListView;

    private String[] genres = new String[] {"Rock", "Country",
            "Jazz", "Pop", "Classic", "Opera",
             "Blues", "J-Pop", "World",
            "Reggae","Hip-Hope", "R&B's"};

    private String[] type = new String[] {"Soft rock", "Americana", "Crossover Jazz", "Dance Pop", "Chamber Music", "Acte de ballet", "Classic Blues", "J-Rock", "Africa", "Dancehall", "Contemporary R&B"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_selector);
        ButterKnife.bind(this);

//        mListView = (ListView) findViewById(R.id.listView);
//        mTypeTextView = (TextView) findViewById(R.id.typeTextView);


        MyMusicSelectorArrayAdapter adapter = new MyMusicSelectorArrayAdapter(this, android.R.layout.simple_list_item_1, genres, type); //must match constructor!
        mListView.setAdapter(adapter);


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String music = ((TextView)view).getText().toString();
                Toast.makeText(MusicSelectorActivity.this, music, Toast.LENGTH_LONG).show();
            }
        });




        Intent intent = getIntent();
        String type = intent.getStringExtra("type");
        mTypeTextView.setText("Here are all the music genres list: " + type);
    }
}