package com.moringaschool.live_cleanliness.tabs;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.moringaschool.live_cleanliness.CleanersDetails;
import com.moringaschool.live_cleanliness.CleaningDetailsOne;
import com.moringaschool.live_cleanliness.InstallationDetailsOne;
import com.moringaschool.live_cleanliness.R;
import com.moringaschool.live_cleanliness.WellnessAndCareDetails;
import com.moringaschool.live_cleanliness.adapters.ProductAdapter;

public class FragmentCleaner extends Fragment {

    View v;
    ListView listView;
    ArrayAdapter<CleanersDetails> mAdapter;
    private String[] sTitle = {"Property management cleaning services","Office cleaning","Warehouse cleaning","Commercial building cleaning services"};
    private String[] onDescription = {"Cleaning services are tailored for property managers to ensure their premises stay clean.","A perfect clean for your offices. Sit back and let our cleaning Professionals take care of your office cleaning","Cleaning services are tailored to the needs of warehouse facilities.","Cleaning services are tailored for property managers to ensure their premises stay clean."};
    private int[] bssImages = {R.drawable.office,R.drawable.cleaneroff,R.drawable.warehouse,R.drawable.service};
     public FragmentCleaner(){

     }
     @Nullable
     @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstance){
         v=inflater.inflate(R.layout.cleanerproduct_fragment,container,false);

         listView =(ListView) v.findViewById(R.id.listCleaner);

         ProductAdapter adapter = new   ProductAdapter(getActivity(),sTitle,onDescription,bssImages);
         listView.setAdapter(adapter);

         listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 Intent intent = new Intent(getContext(), CleaningDetailsOne.class);
                 startActivity(intent);

             }
         });
         return v;
     }
}
