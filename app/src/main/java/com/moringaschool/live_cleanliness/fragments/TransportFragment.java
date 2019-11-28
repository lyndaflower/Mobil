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
import com.moringaschool.live_cleanliness.adapters.TransportAdapter;

public class TransportFragment extends Fragment {
    private String[] bssName = {"YEGO cab","Yego Moto","250 Taxi","Move by Volks Wagen"};
    private int[] bssImage = {R.drawable.yegocab,R.drawable.yegomoto,R.drawable.taxi,R.drawable.move};
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


        View view = inflater.inflate(R.layout.fragment_transport, null);
        businessGrid=view.findViewById(R.id.installation_bss);
//getDialog().setTitle("Installation");

        TransportAdapter adapter=new TransportAdapter(getActivity(),bssName,bssImage);
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
