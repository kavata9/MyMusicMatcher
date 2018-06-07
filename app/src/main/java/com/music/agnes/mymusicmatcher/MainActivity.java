package com.music.agnes.mymusicmatcher;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    private Button mFindMusicMatcherButton;
    private EditText mTypeEditText;
    private TextView mAppNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTypeEditText = (EditText) findViewById(R.id.typeEditText);
        mFindMusicMatcherButton = (Button) findViewById(R.id.findButton);
        mAppNameTextView = (TextView) findViewById(R.id.textView);
        Typeface ostrichFont = Typeface.createFromAsset(getAssets(), "fonts/ostrich-regular.ttf");
        mAppNameTextView.setTypeface(ostrichFont);

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