package com.example.strivezhe_chen.footballfans.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by StriveZhe_Chen on 2017/3/1.
 *
 */

public class myFragmentPagerAdapter extends FragmentStatePagerAdapter {

    //用List存储所有的fragment
    private List<Fragment> fragmentsList;

    public myFragmentPagerAdapter(FragmentManager fm, ArrayList<Fragment> list) {
        super(fm);
        this.fragmentsList = list;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentsList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentsList.size();
    }
}
