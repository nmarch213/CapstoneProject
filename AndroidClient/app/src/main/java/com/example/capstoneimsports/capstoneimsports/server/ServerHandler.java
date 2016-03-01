package com.example.capstoneimsports.capstoneimsports.server;

import android.content.Context;

import com.example.capstoneimsports.capstoneimsports.models.User;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Nick on 3/1/2016.
 */
public class ServerHandler {

    private final OkHttpClient client = new OkHttpClient();

    public static final MediaType JSON = MediaType.parse("applicatoin/json; charset=utf-8");


    //Do a get request

    String doGetRequest(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    //Do a post request

    String doPostRequest(String url, String json) throws IOException{
        RequestBody body = RequestBody.create(JSON,json);
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}
