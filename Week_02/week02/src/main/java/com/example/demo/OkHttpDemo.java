package com.example.demo;

import okhttp3.*;

import java.io.IOException;

public class OkHttpDemo {
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();

    String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public static void main(String[] args) {
        OkHttpDemo demo = new OkHttpDemo();
        try {
            String res = demo.post("http://localhost:8081","{}");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
