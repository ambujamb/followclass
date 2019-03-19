package com.example.ambuj.followclass.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;

import com.example.ambuj.followclass.R;
import com.example.ambuj.followclass.classes.Transition_Class;
import com.example.ambuj.followclass.fragments.DashboardFrgament;
import com.example.ambuj.followclass.fragments.HomeFragment;
import com.example.ambuj.followclass.fragments.NotificationFragment;
import com.example.ambuj.followclass.fragments.AdminProfileFragment;
import com.example.ambuj.followclass.fragments.OthersProfileFragment;

public class HomeScreen extends AppCompatActivity {
    private String usertype="admin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        loadFragment(new HomeFragment());

        // gettting bottom navigation view
        BottomNavigationView navigationView = (BottomNavigationView) findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        initAnimation();
    }


    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

            switch(menuItem.getItemId()){
                case R.id.navigation_home: loadFragment(new HomeFragment());
                    return true;
                case R.id.navigation_dashboard: loadFragment(new DashboardFrgament());
                    return true;
                case R.id.navigation_notification: loadFragment(new NotificationFragment());
                    return true;
                case R.id.navigation_profile:{
                    if(usertype == "admin")
                        loadFragment(new AdminProfileFragment());
                    else
                        loadFragment(new OthersProfileFragment());
                        return true;
                }


            }
            return false;
        }
    };

    private void initAnimation() {
        Transition_Class transition_class = new Transition_Class(this);
        transition_class.ExplodeAnimation();

    }

    private void loadFragment(Fragment fragment) {
        // for loading fragment
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_container,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }


}
