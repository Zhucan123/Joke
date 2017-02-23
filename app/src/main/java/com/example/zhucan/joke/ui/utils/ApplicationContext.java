package com.example.zhucan.joke.ui.utils;

import android.app.Application;
import android.content.Context;

/**
 * Created by lubin on 2016/12/4.
 */

public class ApplicationContext extends Application {
    private static Context mContext;

    public static Context getContext() {
       return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mContext = this;
    }
}
