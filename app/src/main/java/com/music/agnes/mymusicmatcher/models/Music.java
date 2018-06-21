
package com.music.agnes.mymusicmatcher.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel

public class Music {

    @SerializedName("body")
    @Expose
    private Body body;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Music() {
    }

    /**
     * 
     * @param body
     */
    public Music(Body body) {
        super();
        this.body = body;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

}
