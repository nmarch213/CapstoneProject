package com.example.capstoneimsports.capstoneimsports.server;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Credentials;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Nick on 3/1/2016.
 */
public class ServerHandler {

    public static final MediaType JSON = MediaType.parse("application/json;charset=UTF-8");
    public final OkHttpClient client = new OkHttpClient();

    public ServerHandler() {

    }

    //Do a get request
    public String doGetRequest(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();

        return response.body().string();
    }


    //Do a post request

    public String doPostRequest(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    //Logs in a user, and authenticates them
    public String doLoginAuth(String url, String email, String password) throws IOException {
        String credential = Credentials.basic(email, password);
        Request request = new Request.Builder()
                .header("Authorization", credential)
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}
