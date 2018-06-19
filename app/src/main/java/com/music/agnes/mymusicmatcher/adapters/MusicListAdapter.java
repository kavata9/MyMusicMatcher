package com.music.agnes.mymusicmatcher.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.music.agnes.mymusicmatcher.R;
import com.music.agnes.mymusicmatcher.models.Track;
import com.music.agnes.mymusicmatcher.models.TrackList;

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

    public class TrackViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.musicsImageView) ImageView mMusicsImageView;
        @BindView(R.id.MusicNameTextView) TextView mMusicNameTextView;
        @BindView(R.id.TrackNameTextView) TextView mTrackTextView;
//        @BindView(R.id.AlbumNameTextView) TextView mNameTextView;
        @BindView(R.id.ArtistNameTextView) TextView mArtistTextView;
        @BindView(R.id.GenresNameTextView) TextView mCategoryTextView;
        @BindView(R.id.ratingTextView) TextView mRatingTextView;

        private Context mContext;

        public TrackViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindTrack(TrackList trackList) {
            mTrackTextView.setText(trackList.getTrack().getTrackName());
            mMusicNameTextView.setText(trackList.getTrack().getAlbumName());
//            mNameTextView.setText(trackList.getTrack().getAlbumName());
            mArtistTextView.setText(trackList.getTrack().getArtistName());
            mCategoryTextView.setText(trackList.getTrack().getPrimaryGenres().toString());
            mRatingTextView.setText("Rating: " + trackList.getTrack().getTrackRating() + "/5");
        }
    }
}