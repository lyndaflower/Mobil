package com.moringaschool.live_cleanliness.fragments;

import android.app.FragmentManager;

import android.content.Intent;


import android.os.Bundle;
import android.preference.PreferenceManager;
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
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;


import com.moringaschool.live_cleanliness.InstallationDetails;

import com.moringaschool.live_cleanliness.Models.InstallationCustomer;
import com.moringaschool.live_cleanliness.R;
import com.moringaschool.live_cleanliness.adapters.InstallationAdapter;

public class InstallationFragment extends DialogFragment {

    private String[] bssName = {"Yogi IT Services","Honorine"};
    private int[] bssImage = {R.drawable.yogi,R.drawable.clean};
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


        View view = inflater.inflate(R.layout.fragment_installation, null);
businessGrid=view.findViewById(R.id.installation_bss);
//getDialog().setTitle("Installation");

InstallationAdapter adapter=new InstallationAdapter(getActivity(),bssName,bssImage);
businessGrid.setAdapter(adapter);

businessGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            Intent intent = new Intent(getContext(), InstallationDetails.class);
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