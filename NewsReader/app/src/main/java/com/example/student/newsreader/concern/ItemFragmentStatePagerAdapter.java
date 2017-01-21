package com.example.student.newsreader.concern;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by ohgi on 2017/01/21.
 */

public class ItemFragmentStatePagerAdapter extends FragmentStatePagerAdapter{

    public ItemFragmentStatePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new ItemFragment();
    }

    @Override
    public int getCount() {
        return 0;
    }
}
