package com.example.ambuj.followclass.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.ambuj.followclass.R;
import com.example.ambuj.followclass.classes.ViewpagerAdapter;


public class AdminProfileFragment extends Fragment implements TabLayout.OnTabSelectedListener{
    private TabLayout profile_tablayout;
    private ViewPager profile_viewpager;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view =  inflater.inflate(R.layout.fragment_admin_profile,null);
        profile_tablayout = view.findViewById(R.id.profile_tablayout);
        profile_viewpager = view.findViewById(R.id.profile_viewpager);

        profile_tablayout.addTab(profile_tablayout.newTab().setText("Personal Profile"));
        profile_tablayout.addTab(profile_tablayout.newTab().setText("School Profile"));

        profile_tablayout.setTabGravity(TabLayout.GRAVITY_FILL);

        ViewpagerAdapter adapter = new ViewpagerAdapter(getFragmentManager(),profile_tablayout.getTabCount());


        profile_viewpager.setAdapter(adapter);

        profile_tablayout.setOnTabSelectedListener(this);
        return view;

    }



    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
    {
        inflater.inflate(R.menu.profile_menu,menu);
        super.onCreateOptionsMenu(menu,inflater);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        profile_viewpager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
