package com.example.zhucan.joke.ui.utils;


import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by zhucan on 2017/2/22.
 */

public class SharedPreference {
    Context context;
    public SharedPreference(Context context){
        this.context=context;

    }

    private  SharedPreferences preferences=context.getSharedPreferences("data",1);
    private  SharedPreferences.Editor editor = preferences.edit();

    private  final static String KEY_PAGE="mydata";


    public   void putIntValue(){
        int page=getIntValuse();
       editor.putInt(KEY_PAGE,page+1);
        editor.commit();
    }

    public  int getIntValuse(){
        return preferences.getInt(KEY_PAGE,0);
    }


}
