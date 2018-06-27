package com.music.agnes.mymusicmatcher.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
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
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(MainActivity.this, LogInActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
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