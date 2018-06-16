package com.music.agnes.mymusicmatcher;

import android.content.Context;
import android.widget.ArrayAdapter;

public class MyMusicSelectorArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mGenres;
    private String[] mType;

    public MyMusicSelectorArrayAdapter(Context mContext, int resource, String[] mGenres, String[] mType) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mGenres = mGenres;
        this.mType = mType;
    }

    @Override
    public Object getItem(int position) {
        String genres = mGenres[position];
        String type = mType[position];
        return String.format("%s \nServes great: %s", genres, type);
    }

    @Override
    public int getCount() {
        return mGenres.length;
    }
}

