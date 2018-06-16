package com.music.agnes.mymusicmatcher;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;

import okhttp3.Request;

public class MusicService {

    public static void findArtists(String name, Callback callback) {

        OkHttpClient client = new OkHttpClient.Builder().build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.MUSIC_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.MUSIC_QUERY_PARAMETER ,artist);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .header("Authorization", "Bearer " + Constants.MUSIC_API_KEY)
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }


}

}
