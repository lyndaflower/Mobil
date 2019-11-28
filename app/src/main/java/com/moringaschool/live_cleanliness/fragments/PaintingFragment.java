package com.moringaschool.live_cleanliness.fragments;

import android.app.FragmentManager;
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

import com.moringaschool.live_cleanliness.Models.InstallationCustomer;
import com.moringaschool.live_cleanliness.R;
import com.moringaschool.live_cleanliness.adapters.InstallationAdapter;
import com.moringaschool.live_cleanliness.adapters.PaintingAdapter;

public class PaintingFragment extends Fragment {
    private String[] bssName = {"Inema Art Center","Niyo Art Gallery","Ivuka Art Center","Tongo Art Gallery"};
    private int[] bssImage = {R.drawable.inema,R.drawable.niyo,R.drawable.ivuka,R.drawable.tongo};
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

        PaintingAdapter adapter=new PaintingAdapter(getActivity(),bssName,bssImage);
        businessGrid.setAdapter(adapter);

        businessGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
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

