package com.music.agnes.mymusicmatcher;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class MusicSelectorActivity extends Activity {
    private TextView mTypeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_selector);
        mTypeTextView = (TextView) findViewById(R.id.typeTextView);
        Intent intent = getIntent();
        String type = intent.getStringExtra("type");
        mTypeTextView.setText("Here are all the music type list: " + type);
    }
}