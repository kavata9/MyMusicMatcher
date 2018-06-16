package com.music.agnes.mymusicmatcher;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;

import okhttp3.Request;

public class MusicService {

    public static void findArtists(String name, Callback callback) {

        OkHttpClient client = new OkHttpClient.Builder().build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.API_PARAMETER,Constants.MUSIC_API_KEY);
        urlBuilder.addQueryParameter(Constants.QUERY_PARAMETER,Artists);
        String url = urlBuilder.build().toString();

        Request request= new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }


}

}
