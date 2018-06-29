package com.music.agnes.mymusicmatcher.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.music.agnes.mymusicmatcher.Constants;
import com.music.agnes.mymusicmatcher.R;
import com.music.agnes.mymusicmatcher.models.TrackList;

import org.parceler.Parcels;


import butterknife.BindView;
import butterknife.ButterKnife;

public class MusicDetailFragment extends Fragment implements View.OnClickListener {

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


        mAlbumLabel.setOnClickListener(this);
        mNameLabel.setOnClickListener(this);
        mTrackNameLabel.setOnClickListener(this);

        mSaveMusicButton.setOnClickListener(this);




        return view;
    }

    @Override
    public void onClick(View v) {

        if (v == mSaveMusicButton) {
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            String uid = user.getUid();
            DatabaseReference artistRef = FirebaseDatabase
                    .getInstance()
                    .getReference(Constants.FIREBASE_CHILD_ARTISTS)
                    .child(uid);
            DatabaseReference pushRef = artistRef.push();
            String pushId = pushRef.getKey();
            mTrackList.setPushId(pushId);
            pushRef.setValue(mTrackList);

            Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();
        }
    }
}