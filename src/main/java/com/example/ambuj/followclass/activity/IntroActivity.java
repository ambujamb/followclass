package com.example.ambuj.followclass.activity;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ambuj.followclass.Navigation_Main_Activity;
import com.example.ambuj.followclass.classes.PrefManager;
import com.example.ambuj.followclass.R;


public class IntroActivity extends AppCompatActivity {

    private RelativeLayout relativeLayout;

    private ViewPager viewPager;
    private MyViewPagerAdapter myViewPagerAdapter;
    private LinearLayout linearLayout;
    private TextView[] dots;
     int[] layouts;
    private int[] images;
    private Button btnNext;
    private PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Checking for the first time launch befoe calling setContentView()

        prefManager = new PrefManager(this);
        if(!prefManager.isFirstTimeLaunch()){
            launchScreen();
            finish();
        }


        //Making Notification Bar Transparent
        if(Build.VERSION.SDK_INT>=21){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        }

        setContentView(R.layout.activity_main);

       relativeLayout = findViewById(R.id.relative_layout);
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        linearLayout = (LinearLayout)findViewById(R.id.layout_dots);
        btnNext = (Button)findViewById(R.id.btn_next);

        //images for background
        images = new int[]{
                R.drawable.intro_image1,
                R.drawable.intro_image2,
                R.drawable.intro_image3,
                R.drawable.intro_image4
        };


        //Layout of all welcome sliders

        layouts = new int[]{
                R.layout.welcome_slide1,
                R.layout.welcome_slide2,
                R.layout.welcome_slide3,
                R.layout.welcome_slide4
        };

        addingBottomDots(0);

        //making Notification Bar Transparent
        changeStatusBarColor();

        myViewPagerAdapter = new MyViewPagerAdapter();
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);


        btnNext.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                int current = getItem(+1);

                if(current < layouts.length){
                    //move to next screen
                    viewPager.setCurrentItem(current);
                }
                else
                {
                    launchScreen();
                }

            }
        });




    }

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }


    private void changeStatusBarColor() {

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }

    }

    private void addingBottomDots(int currentPage) {
        dots = new TextView[layouts.length];

        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active_color);
        int [] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive_color);

        linearLayout.removeAllViews();
        for(int i=0;i<dots.length;i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[currentPage]);
            relativeLayout.setBackgroundResource(images[currentPage]);
            linearLayout.addView(dots[i]);

        }

        if(dots.length>0){
            dots[currentPage].setTextColor(colorsActive[currentPage]);
        }
    }

    private void launchScreen() {
        prefManager.setFirstTimeLaunch(false);
        Intent i =new Intent(this, Navigation_Main_Activity.class);
        startActivity(i);
        finish();
    }

    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener(){

        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            addingBottomDots(i);


            if(i == layouts.length -1){
                btnNext.setText(getString(R.string.got_it));
            }else
            {
                btnNext.setText(getString(R.string.next));
            }

        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };

    //viewPager Adapter

    public class MyViewPagerAdapter extends PagerAdapter{

        private LayoutInflater layoutInflater;
        public MyViewPagerAdapter(){

        }
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(layouts[position], container, false);
            container.addView(view);

            return view;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view == o;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }
}

