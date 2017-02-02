package com.example.student.newsreader.concern;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.util.SparseArrayCompat;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.student.newsreader.R;
import com.example.student.newsreader.adapters.ItemsAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ohgi on 2017/01/21.
 */

public class ItemFragmentStatePagerAdapter extends FragmentStatePagerAdapter {

    private  ArrayList<QiitaResponse> mList;
    private int count;

    public ItemFragmentStatePagerAdapter(FragmentManager fm) {
        super(fm);
        mList = new ArrayList<QiitaResponse>();
        count = 1;
    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        bundle.putString("title", mList.get(position).getTitle());
        bundle.putString("desc", mList.get(position).getDesc());
        bundle.putString("created_at", mList.get(position).getCreated_at());

        ItemFragment fragment = new ItemFragment();
        fragment.setArguments(bundle);

        return fragment;
    }

    public int getCount() { return mList.size(); }

    public void add(QiitaResponse item){
        mList.add(item);
        notifyDataSetChanged();
    }

    public void addAll(ArrayList<QiitaResponse> items) {
        mList.addAll(items);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Page" + (position + 1);
    }
}
