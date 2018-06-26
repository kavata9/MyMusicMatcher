package com.music.agnes.mymusicmatcher.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.music.agnes.mymusicmatcher.Constants;
import com.music.agnes.mymusicmatcher.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends Activity implements View.OnClickListener {

    private DatabaseReference mSearchedArtistReference;


    @BindView(R.id.findMusicMatcherButton) Button mFindMusicMatcherButton;
//    @BindView(R.id.appNameTextView) EditText mTypeEditText;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;
    @BindView(R.id.savedArtistsButton) Button msavedArtistButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Typeface ostrichFont = Typeface.createFromAsset(getAssets(), "fonts/ostrich-regular.ttf");
        mAppNameTextView.setTypeface(ostrichFont);

        mFindMusicMatcherButton.setOnClickListener(this);
        msavedArtistButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v == mFindMusicMatcherButton) {
            Intent intent = new Intent(MainActivity.this, MusicSelectorListActivity.class);
            startActivity(intent);
        }

        if (v == msavedArtistButton) {
            Intent intent = new Intent(MainActivity.this, SavedArtistListActivity.class);
            startActivity(intent);
        }
    }
}