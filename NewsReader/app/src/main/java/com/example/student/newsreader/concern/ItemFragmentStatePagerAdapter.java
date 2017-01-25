package com.example.student.newsreader.concern;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.util.SparseArrayCompat;
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

public class ItemFragmentStatePagerAdapter extends FragmentStatePagerAdapter implements ListAdapter {

    List<QiitaResponse> mItems;
    static Context context;

    public ItemFragmentStatePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        QiitaResponse item = mItems.get(position);

        Bundle bundle = new Bundle();
        bundle.putString("title", mItems.get(0).getTitle());
        bundle.putString("desc", mItems.get(1).getDesc());

        ItemFragment fragment = new ItemFragment();
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int getCount() {
        return 0;
    }

    public void setItems(ArrayList<QiitaResponse> items) {
        this.mItems = items;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }
}
