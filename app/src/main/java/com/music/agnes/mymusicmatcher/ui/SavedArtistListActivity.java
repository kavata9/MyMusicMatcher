package com.music.agnes.mymusicmatcher.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.music.agnes.mymusicmatcher.Constants;
import com.music.agnes.mymusicmatcher.R;
import com.music.agnes.mymusicmatcher.adapters.FirebaseMusicViewHolder;
import com.music.agnes.mymusicmatcher.models.TrackList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SavedArtistListActivity extends Activity {

    private DatabaseReference mArtistReference;
    private FirebaseRecyclerAdapter mFirebaseAdapter;

    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_music_selector);
        ButterKnife.bind(this);

        mArtistReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_ARTISTS);
        setUpFirebaseAdapter();
    }

    private void setUpFirebaseAdapter() {
        mFirebaseAdapter = new FirebaseRecyclerAdapter<TrackList, FirebaseMusicViewHolder>
                (TrackList.class, R.layout.music_list_item, FirebaseMusicViewHolder.class,
                        mArtistReference) {

            @Override
            protected void populateViewHolder(FirebaseMusicViewHolder viewHolder,
                                              TrackList model, int position) {
                viewHolder.bindTrackList(model);
            }
        };
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFirebaseAdapter.cleanup();
    }
}

