
package com.music.agnes.mymusicmatcher.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;


@Parcel
public class PrimaryGenres {

    @SerializedName("music_genre_list")
    @Expose
     List<MusicGenreList> musicGenreList = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public PrimaryGenres() {
    }

    /**
     * 
     * @param musicGenreList
     */
    public PrimaryGenres(List<MusicGenreList> musicGenreList) {
        super();
        this.musicGenreList = musicGenreList;
    }

    public List<MusicGenreList> getMusicGenreList() {
        return musicGenreList;
    }

    public void setMusicGenreList(List<MusicGenreList> musicGenreList) {
        this.musicGenreList = musicGenreList;
    }

}
