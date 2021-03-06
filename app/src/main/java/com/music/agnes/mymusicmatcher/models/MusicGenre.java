
package com.music.agnes.mymusicmatcher.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel

public class MusicGenre {

    @SerializedName("music_genre_id")
    @Expose
     Integer musicGenreId;
    @SerializedName("music_genre_parent_id")
    @Expose
     Integer musicGenreParentId;
    @SerializedName("music_genre_name")
    @Expose
     String musicGenreName;
    @SerializedName("music_genre_name_extended")
    @Expose
     String musicGenreNameExtended;
    @SerializedName("music_genre_vanity")
    @Expose
     String musicGenreVanity;

    /**
     * No args constructor for use in serialization
     * 
     */
    public MusicGenre() {
    }

    /**
     * 
     * @param musicGenreName
     * @param musicGenreId
     * @param musicGenreNameExtended
     * @param musicGenreVanity
     * @param musicGenreParentId
     */
    public MusicGenre(Integer musicGenreId, Integer musicGenreParentId, String musicGenreName, String musicGenreNameExtended, String musicGenreVanity) {
        super();
        this.musicGenreId = musicGenreId;
        this.musicGenreParentId = musicGenreParentId;
        this.musicGenreName = musicGenreName;
        this.musicGenreNameExtended = musicGenreNameExtended;
        this.musicGenreVanity = musicGenreVanity;
    }

    public Integer getMusicGenreId() {
        return musicGenreId;
    }

    public void setMusicGenreId(Integer musicGenreId) {
        this.musicGenreId = musicGenreId;
    }

    public Integer getMusicGenreParentId() {
        return musicGenreParentId;
    }

    public void setMusicGenreParentId(Integer musicGenreParentId) {
        this.musicGenreParentId = musicGenreParentId;
    }

    public String getMusicGenreName() {
        return musicGenreName;
    }

    public void setMusicGenreName(String musicGenreName) {
        this.musicGenreName = musicGenreName;
    }

    public String getMusicGenreNameExtended() {
        return musicGenreNameExtended;
    }

    public void setMusicGenreNameExtended(String musicGenreNameExtended) {
        this.musicGenreNameExtended = musicGenreNameExtended;
    }

    public String getMusicGenreVanity() {
        return musicGenreVanity;
    }

    public void setMusicGenreVanity(String musicGenreVanity) {
        this.musicGenreVanity = musicGenreVanity;
    }

}
