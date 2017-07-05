package com.example.berlian.si_rt;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.berlian.si_rt.kegiatan.kegiatan;

/**
 * Created by berlian on 6/20/2017.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter{

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position ==0) {
            return new kegiatan();
        } else if (position == 1) {
            return new BlankFragment();
        } else return new kegiatan();
    }

    @Override
    public int getCount() {
        return 3;
    }
}
