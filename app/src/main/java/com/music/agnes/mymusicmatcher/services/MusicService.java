package com.music.agnes.mymusicmatcher.services;


import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.music.agnes.mymusicmatcher.Constants;
import com.music.agnes.mymusicmatcher.models.Track;
import com.music.agnes.mymusicmatcher.models.TrackList;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;


import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;

import okhttp3.Request;
import okhttp3.Response;

public class MusicService {

    public static void findArtists(String artistName, Callback callback) {

    OkHttpClient client = new OkHttpClient.Builder().build();

    HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.MUSIC_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.PARAM_KEY,Constants.MUSIC_API_KEY );
        urlBuilder.addQueryParameter(Constants.MUSIC_QUERY_PARAMETER,artistName);
    String url = urlBuilder.build().toString();

    Request request= new Request.Builder()
            .url(url)
            .build();

        Log.d("Generated", "Request: "+request);
    Call call = client.newCall(request);
        call.enqueue(callback);
}


    public static List<TrackList> artistResults(Response response) {
        List<TrackList> result = new ArrayList<>();

        try {
            String jsonData = response.body().string();

            if (response.isSuccessful()) {
                // The response JSON is an array of business objects within an object so we need to get that array
                JSONObject musicJSON = new JSONObject(jsonData);
                JSONArray bodyJSON = musicJSON.getJSONObject("message").getJSONObject("body").getJSONArray("track_list");

                Type collectionType = new TypeToken<List<TrackList>>() {}.getType();
                Gson gson = new GsonBuilder().create();
                result = gson.fromJson(bodyJSON.toString(), collectionType);
            }
        } catch (JSONException | NullPointerException | IOException e) {
            e.printStackTrace();
        }

        return result;

    }
}