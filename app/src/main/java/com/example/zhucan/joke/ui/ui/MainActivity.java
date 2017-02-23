package com.example.zhucan.joke.ui.ui;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;
import com.example.zhucan.joke.R;
import com.example.zhucan.joke.ui.Adaputers.PullToRefreshListViewAdaputer;
import com.example.zhucan.joke.ui.config.Configs;
import com.example.zhucan.joke.ui.utils.Http.GetJson;
import com.example.zhucan.joke.ui.utils.HttpManager;
import com.example.zhucan.joke.ui.utils.SharedPreference;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




public class MainActivity extends Activity {

    private PullToRefreshListView lv;
    private int JOKE_PAGE = 0;
    private List<GetJson> mlist=null;
    private PullToRefreshListViewAdaputer adaputer;
    private String KEY_PAGE="data";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (PullToRefreshListView) findViewById(R.id.list);
        mlist=new ArrayList<>() ;
       final SharedPreferences  s=getSharedPreferences("data",0);
       final SharedPreferences.Editor editor=s.edit();
        JOKE_PAGE=s.getInt(KEY_PAGE,1)+1;


        MessageTask task = new MessageTask(MainActivity.this, JOKE_PAGE);
        task.execute();


        adaputer=new PullToRefreshListViewAdaputer(MainActivity.this,mlist);
        lv.setAdapter(adaputer);
        lv.setMode(PullToRefreshBase.Mode.BOTH);
        lv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                JOKE_PAGE++;
                MessageTask messageTask=new MessageTask(MainActivity.this,JOKE_PAGE);
                messageTask.execute();
                int page=s.getInt(KEY_PAGE,1);
                editor.putInt(KEY_PAGE,page+1);
                editor.commit();
            }
        });
    }

    public class MessageTask extends AsyncTask<String, Void,String> {

        private Context context = null;
        private int page = 0;
        String callback = null;
        List<GetJson> result = null;

        public MessageTask(Context context, int page) {
            this.context = context;
            this.page=page;

        }

        protected String doInBackground(String... params) {
            Map<String, String> map = new HashMap<>();
            map.put("page", page+"");

            try {
                callback= HttpManager.postRequest(Configs.JOKE_URL, map);

            } catch (IOException e) {
                e.printStackTrace();
            }
          try{ Thread.sleep(1000);}
          catch (InterruptedException e){

          }


            return callback;

        }

        protected void onPostExecute(String string) {
            if (callback != null) {
                Gson gson = new Gson();
                result = gson.fromJson(callback,
                        new TypeToken<List<GetJson>>() {
                        }.getType());
                for (int i=0;i<result.size();i++) {
                    GetJson getJson=result.get(i);
                    mlist.add(getJson);
                }
                adaputer.notifyDataSetChanged();
                lv.onRefreshComplete();


            }
        }

    }

}
