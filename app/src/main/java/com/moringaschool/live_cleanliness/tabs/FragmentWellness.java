package com.moringaschool.live_cleanliness.tabs;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.moringaschool.live_cleanliness.InstallationDetails;
import com.moringaschool.live_cleanliness.InstallationDetailsOne;
import com.moringaschool.live_cleanliness.R;
import com.moringaschool.live_cleanliness.WellnessAndCareDetails;
import com.moringaschool.live_cleanliness.WellnessAndCareDetailsOne;
import com.moringaschool.live_cleanliness.adapters.HowworksAdapter;

public class FragmentWellness extends Fragment {
    View view;
    ListView listView;
    ArrayAdapter<WellnessAndCareDetails> mAdapter;
    private String[] sName = {"Browse & Select","Diagnosis","Job Delivery"};
    private String[] sName2 = {"Find the product that fits your current need","Select the date and time you like a site visit to take place","Book quote provided by the pro, sit back and let us fix your problem"};
    private int[] bssImage = {R.drawable.bullet,R.drawable.time,R.drawable.right};

    public FragmentWellness(){

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.wellness_fragment,container,false);

        listView =(ListView) view.findViewById(R.id.listWelness);

        HowworksAdapter adapter = new HowworksAdapter(getActivity(),sName,sName2,bssImage);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), WellnessAndCareDetailsOne.class);
                startActivity(intent);

            }
        });

        return view;
    }
}
