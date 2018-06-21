
package com.music.agnes.mymusicmatcher.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;
@Parcel

public class Body {


    @SerializedName("track_list")
    @Expose
     List<TrackList> trackList = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Body() {
    }

    /**
     * 
     * @param trackList
     */
    public Body(List<TrackList> trackList) {
        super();
        this.trackList = trackList;
    }

    public List<TrackList> getTrackList() {
        return trackList;
    }

    public void setTrackList(List<TrackList> trackList) {
        this.trackList = trackList;
    }

}
