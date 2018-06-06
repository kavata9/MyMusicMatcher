package com.music.agnes.mymusicmatcher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    public static final String TAG = MainActivity.class.getSimpleName();
    private Button mFindMusicMatcherButton;
    private EditText mLocationEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLocationEditText = (EditText) findViewById(R.id.locationEditText);
        mFindMusicMatcherButton = (Button) findViewById(R.id.findButton);
        mFindMusicMatcherButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String location = mLocationEditText.getText().toString();
                Log.d(TAG, location);
                Intent intent = new Intent(MainActivity.this, MusicSelectorActivity.class);
                startActivity(intent);
            }
        });
    }
}
