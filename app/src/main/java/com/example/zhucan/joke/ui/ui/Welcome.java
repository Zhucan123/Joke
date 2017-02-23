package com.example.zhucan.joke.ui.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.example.zhucan.joke.R;

/**
 * Created by zhucan on 2017/2/18.
 */

public class Welcome extends Activity {
    private int[] background={R.drawable.icon_1,R.drawable.icon_2,R.drawable.icon_3,R.drawable.welcome};
    private int time=3000;

    class loading implements Runnable {
        @Override
        public void run(){
            Intent intent=new Intent();
            intent.setClass(getApplicationContext(),LoginActivity.class);
            startActivity(intent);
            Welcome.this.finish();

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        LinearLayout layout=(LinearLayout)findViewById(R.id.welcome1);
        layout.setBackgroundResource(background[(int)(Math.random()*4)]);

        Handler handler=new Handler();
        handler.postDelayed(new loading(),time);

    }
}