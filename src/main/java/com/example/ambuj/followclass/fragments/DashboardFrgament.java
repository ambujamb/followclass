package com.example.ambuj.followclass.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ambuj.followclass.R;
import com.example.ambuj.followclass.classes.DashboardData;
import com.example.ambuj.followclass.classes.MyRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class DashboardFrgament extends Fragment {

    private AdapterViewFlipper adapterViewFlipper;
    private static final String[] text = {"Hard work beats talent when talent doesn't work.","",""};
    private static final int[] images ={R.drawable.stud_flipper_item1,
                                        R.drawable.stud_flipper_item3,
                                        R.drawable.stud_flipper_item2};



   private String userType = "admin";
  // private String dashboardType;


    RecyclerView recyclerView;
    List<DashboardData> list;
    DashboardData dashboardData;

    String[] studentDashboardTitle = {"Attendance","Events","Worksheet","Track Progress","Push Notification","Chat","Calender","School Search"};
    int[] studentDashboardImages = {R.drawable.ic_attendance,
                                    R.drawable.ic_event,
                                    R.drawable.ic_assignment,
                                    R.drawable.ic_track_progress,
                                    R.drawable.ic_notifications,
                                    R.drawable.ic_forum,
                                    R.drawable.ic_calendar,
                                    R.drawable.ic_school_search};

    String[] teachersDashboardTitle = {"Add Students","Attendance","Add Events","Worksheets","Student Marks","Push Notification","Chat","Staff Directory","School Search"};
    int[] teachersDashboardImages = {R.drawable.ic_person_add,
            R.drawable.ic_attendance,
            R.drawable.ic_event,
            R.drawable.ic_assignment,
            R.drawable.ic_track_progress,
            R.drawable.ic_notifications,
            R.drawable.ic_forum,
            R.drawable.ic_staff_directories,
            R.drawable.ic_school_search};

    String[] adminDashboardTitle = {"Add Teachers","Student Attendance","Events","Push Notifications","Chat","School Search"};
    int[] adminDashboardImages = {R.drawable.ic_person_add,
            R.drawable.ic_attendance,
            R.drawable.ic_event,
            R.drawable.ic_notifications,
            R.drawable.ic_forum,
            R.drawable.ic_school_search};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, null);

        //flipper items adapter
        adapterViewFlipper = view.findViewById(R.id.adapter_view_flipper);

        //creating flipper adapter object
        FlipperAdapter adapter = new FlipperAdapter(getContext(),text,images);
        adapterViewFlipper.setAdapter(adapter);
        adapterViewFlipper.setAutoStart(true);

        //set up recyclerview

         recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2,GridLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(gridLayoutManager);

        list = new ArrayList<>();

        switch(userType){
            case "student": dashboard(studentDashboardTitle,studentDashboardImages);
            break;
            case "teacher": dashboard(teachersDashboardTitle,teachersDashboardImages);
            break;
            case "admin": dashboard(adminDashboardTitle,adminDashboardImages);
            break;
        }



        MyRecyclerViewAdapter myRecyclerViewAdapter = new MyRecyclerViewAdapter(getContext(),list);
        recyclerView.setAdapter(myRecyclerViewAdapter);

        return view;

    }

    private void dashboard(String[] studentDashboardTitle, int[] studentDashboardImages) {
        for(int i=0;i<studentDashboardTitle.length;i++){
            dashboardData = new DashboardData(studentDashboardTitle[i],studentDashboardImages[i]);
            list.add(dashboardData);
        }
    }

    private class FlipperAdapter extends BaseAdapter {
        Context context;
        String[] text;
        int[] images;
        LayoutInflater layoutInflater;
        public FlipperAdapter(Context context, String[] text, int[] images) {
            this.context = context;
            this.text = text;
            this.images = images;
            layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return text.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            view =  layoutInflater.inflate(R.layout.flipper_items,null);

            TextView textname = view.findViewById(R.id.flipper_item_text);
            ImageView image = view.findViewById(R.id.flipper_item_image);

            textname.setText(text[i]);
            image.setImageResource(images[i]);


            return view;
        }
    }
}
