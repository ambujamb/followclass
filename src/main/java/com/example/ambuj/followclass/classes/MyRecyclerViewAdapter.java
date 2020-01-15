package com.example.ambuj.followclass.classes;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ambuj.followclass.R;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<DashboardViewHolder> {

    private Context context;
    private List<DashboardData> list;


    public MyRecyclerViewAdapter(@NonNull Context context,List<DashboardData> list) {

        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public DashboardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dashboard_card,viewGroup,false);


        return new DashboardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DashboardViewHolder dashboardViewHolder, int i) {

        dashboardViewHolder.cardImage.setImageResource(list.get(i).getCardImage());
        dashboardViewHolder.title.setText(list.get(i).getTitle());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
