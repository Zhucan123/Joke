package com.example.zhucan.joke.ui.utils;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by lubin on 2016/11/27.
 */

public class HttpManager {

    private static final String TAG = HttpManager.class.getSimpleName();

    public static String postRequest(String url, Map<String, String> paramMap) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody.Builder builder =new FormBody.Builder();

            Set<String> keySet = paramMap.keySet();
        for(String key:keySet) {
            builder.add(key, paramMap.get(key));
        }

        RequestBody requestBody = builder.build();

        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        String result = "";
        try {
            Response response = okHttpClient.newCall(request).execute();
            if(response.isSuccessful()) {
                result = response.body().string();
            }
        } catch (IOException e) {
            throw e;
        }
        return result;



    }

}
