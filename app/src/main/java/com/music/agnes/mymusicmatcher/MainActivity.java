package com.music.agnes.mymusicmatcher;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
                Toast.makeText(MainActivity.this, "Hello World!", Toast.LENGTH_LONG).show();
            }
        });
    }
}