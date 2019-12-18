package com.example.ambuj.followclass.classes;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.ambuj.followclass.fragments.personal_profile;
import com.example.ambuj.followclass.fragments.school_profile;

public class ViewpagerAdapter extends FragmentStatePagerAdapter {

    int tabcount;

    public ViewpagerAdapter(FragmentManager fm,int tabcount){
        super(fm);
        this.tabcount = tabcount;
    }
    @Override
    public Fragment getItem(int i) {

        switch(i){
            case 0:
                personal_profile tab1 = new personal_profile();
                return tab1;
            case 1: school_profile tab2 = new school_profile();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
