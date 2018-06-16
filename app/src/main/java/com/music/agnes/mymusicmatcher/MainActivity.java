package com.music.agnes.mymusicmatcher;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends Activity implements View.OnClickListener {
    @BindView(R.id.findButton) Button mFindMusicMatcherButton;
    @BindView(R.id.typeEditText) EditText mTypeEditText;
    @BindView(R.id.textView) TextView mAppNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


//        mTypeEditText = (EditText) findViewById(R.id.typeEditText);
//        mFindMusicMatcherButton = (Button) findViewById(R.id.findButton);
//        mAppNameTextView = (TextView) findViewById(R.id.textView);


        Typeface ostrichFont = Typeface.createFromAsset(getAssets(), "fonts/ostrich-regular.ttf");
        mAppNameTextView.setTypeface(ostrichFont);

        mFindMusicMatcherButton.setOnClickListener(this);
    }

//    introduce views to onclick method

    @Override
            public void onClick(View v) {
                if (v == mFindMusicMatcherButton) {
                    String location = mTypeEditText.getText().toString();
                    Intent intent = new Intent(MainActivity.this, MusicSelectorActivity.class);
                    intent.putExtra("location", location);
                    startActivity(intent);
                }
            }
        }

