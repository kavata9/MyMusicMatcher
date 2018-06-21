package com.music.agnes.mymusicmatcher.ui;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


import com.music.agnes.mymusicmatcher.R;
import com.music.agnes.mymusicmatcher.adapters.MusicPagerAdapter;
import com.music.agnes.mymusicmatcher.models.TrackList;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MusicDetailActivity extends AppCompatActivity {
    @BindView(R.id.viewPager) ViewPager mViewPager;
    private MusicPagerAdapter adapterViewPager;
    ArrayList<TrackList> mMusics = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_detail);
        ButterKnife.bind(this);

        mMusics = Parcels.unwrap(getIntent().getParcelableExtra("tracks"));
        int startingPosition = getIntent().getIntExtra("position", 0);

        adapterViewPager = new MusicPagerAdapter(getSupportFragmentManager(), mMusics);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}