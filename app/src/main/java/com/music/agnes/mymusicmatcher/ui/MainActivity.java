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


    @BindView(R.id.findButton) Button mFindMusicMatcherButton;
    @BindView(R.id.typeEditText) EditText mTypeEditText;
    @BindView(R.id.textView) TextView mAppNameTextView;
    @BindView(R.id.savedArtistButton) Button msavedArtistButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

//introducing ref to firebase  to write into it

       mSearchedArtistReference = FirebaseDatabase
              .getInstance()
                .getReference()
               .child(Constants.FIREBASE_CHILD_SEARCHED_ARTIST);//pinpoint artist node

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


//        mTypeEditText = (EditText) findViewById(R.id.typeEditText);
//        mFindMusicMatcherButton = (Button) findViewById(R.id.findButton);
//        mAppNameTextView = (TextView) findViewById(R.id.textView);


        Typeface ostrichFont = Typeface.createFromAsset(getAssets(), "fonts/ostrich-regular.ttf");
        mAppNameTextView.setTypeface(ostrichFont);

        mFindMusicMatcherButton.setOnClickListener(this);
        msavedArtistButton.setOnClickListener(this);
    }

//    introduce views to onclick method

    @Override
            public void onClick(View v) {
                if (v == mFindMusicMatcherButton) {
                    String tracks = mTypeEditText.getText().toString();

                    saveArtistToFirebase(tracks);

                    Intent intent = new Intent(MainActivity.this, MusicSelectorListActivity.class);
                    intent.putExtra("tracks", tracks);
                    startActivity(intent);

                }

                    if (v == msavedArtistButton) {
                        Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, SavedArtistListActivity.class);
                        startActivity(intent);

                    }
                }



    public void saveArtistToFirebase(String artist) {
       mSearchedArtistReference.push().setValue(artist);
    }

}

