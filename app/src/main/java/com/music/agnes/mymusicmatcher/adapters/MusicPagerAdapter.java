package com.music.agnes.mymusicmatcher.adapters;




import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import com.music.agnes.mymusicmatcher.models.TrackList;
import com.music.agnes.mymusicmatcher.ui.MusicDetailFragment;

import java.util.ArrayList;

public class MusicPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<TrackList> mMusics;

    public MusicPagerAdapter(FragmentManager fm, ArrayList<TrackList> tracks) {
        super(fm);
        mMusics = tracks;
    }

    @Override
    public Fragment getItem(int position) {
        return MusicDetailFragment.newInstance(mMusics.get(position));
    }

    @Override
    public int getCount() {
        return mMusics.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mMusics.get(position).getTrack().getTrackName();
    }
}