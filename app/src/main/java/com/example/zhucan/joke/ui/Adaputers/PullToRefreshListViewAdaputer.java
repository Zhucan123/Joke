package com.example.zhucan.joke.ui.Adaputers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.zhucan.joke.R;
import com.example.zhucan.joke.ui.utils.Http.GetJson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhucan on 2017/2/22.
 */

public class PullToRefreshListViewAdaputer extends BaseAdapter {
    Context context;
    List<GetJson> list;

    public PullToRefreshListViewAdaputer(Context context,List<GetJson> list) {
        this.list=list;
        this.context=context;
    }

    public List<Map<String,Object>> getlist(){

    List<Map<String, Object>> items = new ArrayList<>();
    for (int i = 0; i < list.size(); i++) {
        Map<String, Object> item = new HashMap<String, Object>();
        GetJson getJson = list.get(i);
        item.put("username", getJson.getUsername());
        item.put("content", getJson.getContent());
        item.put("icon", getJson.getIconUrl());
        item.put("good", getJson.getPraiseCount() + "");
        item.put("bad", getJson.getCommentCount() + "");
        items.add(item);

    }
        return items;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return list.size();
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        Map<String, Object> map = new HashMap<>();
        map = getlist().get(i);
        if (convertView == null) {

            convertView = LayoutInflater.from(context).inflate(R.layout.showjoke, null);
        }
        ((TextView) convertView.findViewById(R.id.name)).setText(map.get("username").toString());
        Glide.with(context).load(map.get("icon")).fitCenter().into(((ImageView) convertView.findViewById(R.id.head)));
        ((TextView) convertView.findViewById(R.id.jokers)).setText(map.get("content").toString());
        ((TextView) convertView.findViewById(R.id.goodcount)).setText(map.get("good").toString());
        ((TextView) convertView.findViewById(R.id.badcount)).setText(map.get("bad").toString());


        return convertView;

    }


}

