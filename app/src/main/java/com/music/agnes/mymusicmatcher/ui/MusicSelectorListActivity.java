package com.music.agnes.mymusicmatcher.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.music.agnes.mymusicmatcher.R;
import com.music.agnes.mymusicmatcher.adapters.MusicListAdapter;
import com.music.agnes.mymusicmatcher.models.TrackList;
import com.music.agnes.mymusicmatcher.services.MusicService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MusicSelectorListActivity extends AppCompatActivity {
    public static final String TAG = MusicSelectorListActivity.class.getSimpleName();

//    @BindView(R.id.MusicNameTextView) TextView MusicNameTextView;
//    @BindView(R.id.listView) ListView mListView;
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    private MusicListAdapter mAdapter;

    public List<TrackList> mMusics = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_selector);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String tracks = intent.getStringExtra("tracks");

//        MusicNameTextView.setText("Here are all the list of song : " + tracks);

        getTracks(tracks);
    }

    private void getTracks(final String tracks) {
        final MusicService musicService = new MusicService();

        musicService.findArtists(tracks, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                mMusics = musicService.artistResults(response);

                MusicSelectorListActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter = new MusicListAdapter(getApplicationContext(), mMusics);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager =
                                new LinearLayoutManager(MusicSelectorListActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                    }
                });
            }
        });
    }
}