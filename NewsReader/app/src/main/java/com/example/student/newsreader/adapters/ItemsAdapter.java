package com.example.student.newsreader.adapters;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.student.newsreader.R;
import com.example.student.newsreader.concern.QiitaResponse;

import java.util.List;

/**
 * Created by ohgi on 2016/12/18.
 */

public class ItemsAdapter extends BaseAdapter {
    List<QiitaResponse> items;
    static Context context;

    public ItemsAdapter(List<QiitaResponse> items, Context context){
        this.items = items;
        ItemsAdapter.context = context;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Nullable
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        /*
        view = layoutInflater.inflate(R.layout.item, parent, false);

        ((TextView)view.findViewById(R.id.item_title)).setText(items.get(position).getTitle());
        ((TextView)view.findViewById(R.id.item_desc)).setText(String.valueOf(items.get(position).getDesc()));
        */

        view = layoutInflater.inflate(R.layout.fragment_item, parent, false);

        ((TextView)view.findViewById(R.id.title)).setText(items.get(position).getTitle());

        System.out.println(view);

        return view;
    }
}
