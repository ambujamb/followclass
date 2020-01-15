package com.example.ambuj.followclass.classes;

import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ambuj.followclass.R;

public class DashboardViewHolder extends RecyclerView.ViewHolder {

    ImageView cardImage;
    TextView title,secondaryText;

    public DashboardViewHolder(View itemview){
        super(itemview);

        cardImage = itemview.findViewById(R.id.product_image);
        title = itemview.findViewById(R.id.product_title);


    }
}
