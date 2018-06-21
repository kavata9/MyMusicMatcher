
package com.music.agnes.mymusicmatcher.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class MusicGenreList {

    @SerializedName("music_genre")
    @Expose
    private MusicGenre musicGenre;

    /**
     * No args constructor for use in serialization
     * 
     */
    public MusicGenreList() {
    }

    /**
     * 
     * @param musicGenre
     */
    public MusicGenreList(MusicGenre musicGenre) {
        super();
        this.musicGenre = musicGenre;
    }

    public MusicGenre getMusicGenre() {
        return musicGenre;
    }

    public void setMusicGenre(MusicGenre musicGenre) {
        this.musicGenre = musicGenre;
    }

}
