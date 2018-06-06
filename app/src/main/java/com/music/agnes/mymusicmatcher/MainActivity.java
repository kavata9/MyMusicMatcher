package com.music.agnes.mymusicmatcher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    private Button mFindMusicMatcherButton;
    private EditText mTypeEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTypeEditText = (EditText) findViewById(R.id.typeEditText);
        mFindMusicMatcherButton = (Button) findViewById(R.id.findButton);

        mFindMusicMatcherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type = mTypeEditText.getText().toString();
                Intent intent = new Intent(MainActivity.this, MusicSelectorActivity.class);
                intent.putExtra("type", type);
                startActivity(intent);
            }
        });
    }
}