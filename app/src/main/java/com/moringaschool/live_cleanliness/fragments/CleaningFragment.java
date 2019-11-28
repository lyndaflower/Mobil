package com.moringaschool.live_cleanliness.fragments;

import android.app.FragmentManager;

import android.content.Intent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.moringaschool.live_cleanliness.CleanersDetails;
import com.moringaschool.live_cleanliness.InstallationDetails;

import com.moringaschool.live_cleanliness.Models.InstallationCustomer;
import com.moringaschool.live_cleanliness.R;
import com.moringaschool.live_cleanliness.adapters.CleanerAdapter;
import com.moringaschool.live_cleanliness.adapters.PaintingAdapter;

public class CleaningFragment extends Fragment {

    private String[] bssName = {"GREAT BRIGHT CLEANERS CO. LTD","Kigali Dry Cleaners","Diamond Sparkle Cleaning Services","Pickup Laundry Service"};
    private int[] bssImage = {R.drawable.great,R.drawable.clean,R.drawable.clean,R.drawable.clean};
    private ArrayAdapter<InstallationCustomer> stringArrayAdapter;
    private GridView businessGrid;
    private TextView bssesName;

    public InstallationFragment newInstance() {
        return new InstallationFragment();

    }

    //
//    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_painting, null);
        businessGrid=view.findViewById(R.id.installation_bss);
//getDialog().setTitle("Installation");

       CleanerAdapter adapter=new CleanerAdapter(getActivity(),bssName,bssImage);
        businessGrid.setAdapter(adapter);

        businessGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getContext(), CleanersDetails.class);
                startActivity(intent);

                Toast.makeText(getActivity(), bssName[position], Toast.LENGTH_SHORT).show();



            }
        });
        return  view;
    }

    public void show(FragmentManager fm, String businesses) {
    }

//    public void show(FragmentManager fm, String businesses) {
//
//    }
}
