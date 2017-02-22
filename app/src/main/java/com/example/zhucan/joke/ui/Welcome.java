package com.example.zhucan.joke.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.zhucan.joke.R;
import com.example.zhucan.joke.ui.ui.MainActivity;

/**
 * Created by zhucan on 2017/2/18.
 */

public class Welcome extends Activity {
    private int time=3000;

    class loading implements Runnable {
        @Override
        public void run(){
            startActivity(new Intent(getApplication(),MainActivity1.class));
            Welcome.this.finish();

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        Handler handler=new Handler();
        handler.postDelayed(new loading(),time);

    }
}