package com.music.agnes.mymusicmatcher.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.music.agnes.mymusicmatcher.R;
import com.music.agnes.mymusicmatcher.models.TrackList;

import org.parceler.Parcels;


import butterknife.BindView;
import butterknife.ButterKnife;

public class MusicDetailFragment extends Fragment {
    @BindView(R.id.artistImageView) ImageView mImageLabel;
    @BindView(R.id.artistNameTextView) TextView mNameLabel;
    @BindView(R.id.trackNameTextView) TextView mTrackNameLabel;
    @BindView(R.id.albumNameTextView) TextView mAlbumLabel;
    @BindView(R.id.genresTextView) TextView mCategoriesLabel;
    @BindView(R.id.ratingTextView) TextView mRatingLabel;
    @BindView(R.id.saveMusicButton) TextView mSaveMusicButton;

    private TrackList mTrackList;

    public static MusicDetailFragment newInstance(TrackList trackList) {
        MusicDetailFragment musicDetailFragment = new MusicDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("tracklist", Parcels.wrap(trackList));
        musicDetailFragment.setArguments(args);
        return musicDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTrackList = Parcels.unwrap(getArguments().getParcelable("tracklist"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_music_detail, container, false);
        ButterKnife.bind(this, view);

        mNameLabel.setText(mTrackList.getTrack().getArtistName());
        mTrackNameLabel.setText(mTrackList.getTrack().getTrackName());
//        mRatingLabel.setText((mTrackList.getTrack().getTrackRating()));
        mAlbumLabel.setText((mTrackList.getTrack().getAlbumName()));

        return view;
    }
}