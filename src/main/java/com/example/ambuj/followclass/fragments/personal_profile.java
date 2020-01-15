package com.example.ambuj.followclass.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ambuj.followclass.R;

public class personal_profile extends Fragment {
    private TextView name,email_id,mobile_number,role;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_personal_profile,container,false);

        name = view.findViewById(R.id.personal_profile_name);
        email_id = view.findViewById(R.id.personal_profile_email_id);
        mobile_number = view.findViewById(R.id.personal_profile_mobile_number);
        role = view.findViewById(R.id.personal_profile_role);


        return  view;



    }
}
