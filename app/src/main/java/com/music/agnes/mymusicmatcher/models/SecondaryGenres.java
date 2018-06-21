
package com.music.agnes.mymusicmatcher.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;


@Parcel

public class SecondaryGenres {

    @SerializedName("music_genre_list")
    @Expose
     List<String> musicGenreList = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SecondaryGenres() {
    }

    /**
     * 
     * @param musicGenreList
     */
    public SecondaryGenres(List<String> musicGenreList) {
        super();
        this.musicGenreList = musicGenreList;
    }

    public List<String> getMusicGenreList() {
        return musicGenreList;
    }

    public void setMusicGenreList(List<String> musicGenreList) {
        this.musicGenreList = musicGenreList;
    }

}
