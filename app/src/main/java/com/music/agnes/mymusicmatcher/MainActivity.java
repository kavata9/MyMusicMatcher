package com.music.agnes.mymusicmatcher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    private Button mFindMusicMatcherButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFindMusicMatcherButton = (Button) findViewById(R.id.findButton);
        mFindMusicMatcherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MusicSelectorActivity.class);
                startActivity(intent);
            }
        });
    }
}