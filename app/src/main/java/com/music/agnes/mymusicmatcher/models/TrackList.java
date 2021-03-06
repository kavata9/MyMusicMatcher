
package com.music.agnes.mymusicmatcher.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;
@Parcel

public class TrackList {

    @SerializedName("track")
    @Expose
     Track track;

    /**
     * No args constructor for use in serialization
     * 
     */
    public TrackList() {
    }
    private String pushId;

    /**
     * 
     * @param track
     */
    public TrackList(Track track) {
        super();
        this.track = track;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }


    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }
}
