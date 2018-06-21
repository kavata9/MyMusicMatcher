package com.music.agnes.mymusicmatcher.adapters;

import android.content.Context;
import android.content.Intent;
import android.preference.MultiSelectListPreference;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.music.agnes.mymusicmatcher.R;
import com.music.agnes.mymusicmatcher.models.TrackList;
import com.music.agnes.mymusicmatcher.ui.MusicDetailActivity;



import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MusicListAdapter extends RecyclerView.Adapter<MusicListAdapter.TrackViewHolder> {
    private List<TrackList> mMusics ;
    private Context mContext;

    public MusicListAdapter(Context context, List<TrackList> tracks) {
        mContext = context;
        mMusics = tracks;
    }

    @Override
    public MusicListAdapter.TrackViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.music_list_item, parent, false);
        TrackViewHolder viewHolder = new TrackViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MusicListAdapter.TrackViewHolder holder, int position) {
        holder.bindTrack(mMusics.get(position));
    }

    @Override
    public int getItemCount() {
        return mMusics.size();
    }

    public class TrackViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.musicsImageView) ImageView mMusicsImageView;
        @BindView(R.id.MusicNameTextView) TextView mMusicNameTextView;
        @BindView(R.id.TrackNameTextView) TextView mTrackTextView;
        @BindView(R.id.ArtistNameTextView) TextView mArtistTextView;
        @BindView(R.id.GenresNameTextView) TextView mCategoryTextView;
        @BindView(R.id.ratingTextView) TextView mRatingTextView;

        private Context mContext;

        public TrackViewHolder(View itemView) {


            super(itemView);
            ButterKnife.bind(this, itemView);

            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        public void bindTrack(TrackList trackList) {


            mTrackTextView.setText(trackList.getTrack().getTrackName());
            mMusicNameTextView.setText(trackList.getTrack().getAlbumName());
            mArtistTextView.setText(trackList.getTrack().getArtistName());
            mCategoryTextView.setText(trackList.getTrack().getPrimaryGenres().toString());
            mRatingTextView.setText("Rating: " + trackList.getTrack().getTrackRating() + "/5");
        }

        @Override
        public void onClick(View v) {
            Log.d("click listener", "working!");
            Toast.makeText(v.getContext(), "Clicked Laugh Vote", Toast.LENGTH_SHORT).show();
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, MusicDetailActivity.class);
            intent.putExtra("position", itemPosition + "");
            intent.putExtra("tracks", Parcels.wrap(mMusics));
            mContext.startActivity(intent);
        }
    }
}