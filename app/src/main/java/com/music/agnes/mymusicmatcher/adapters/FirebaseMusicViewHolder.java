package com.music.agnes.mymusicmatcher.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.music.agnes.mymusicmatcher.Constants;
import com.music.agnes.mymusicmatcher.R;
import com.music.agnes.mymusicmatcher.models.TrackList;
import com.music.agnes.mymusicmatcher.ui.MusicDetailActivity;

import org.parceler.Parcels;

import java.util.ArrayList;

public class FirebaseMusicViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;

    View mView;
    Context mContext;

    public FirebaseMusicViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindTrackList(TrackList trackList) {

        TextView ArtistNameTextView =  mView.findViewById(R.id.ArtistNameTextView);
        TextView AlbumNameTextView =  mView.findViewById(R.id.AlbumNameTextView);
        TextView ratingTextView =  mView.findViewById(R.id.ratingTextView);


        ArtistNameTextView.setText(trackList.getTrack().getArtistName());
        AlbumNameTextView.setText(trackList.getTrack().getAlbumName());
        ratingTextView.setText(trackList.getTrack().getTrackRating());


    }

    @Override
    public void onClick(View view) {
        final ArrayList<TrackList> artists = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_ARTISTS);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    artists.add(snapshot.getValue(TrackList.class));
                }

                int itemPosition = getLayoutPosition();

                Intent intent = new Intent(mContext, MusicDetailActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("tracks", Parcels.wrap(artists));

                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}

