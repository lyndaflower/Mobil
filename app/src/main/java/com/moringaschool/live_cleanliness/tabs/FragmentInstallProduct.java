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

import com.moringaschool.live_cleanliness.InstallationDetails;
import com.moringaschool.live_cleanliness.InstallationDetailsOne;
import com.moringaschool.live_cleanliness.R;
import com.moringaschool.live_cleanliness.adapters.HowworksAdapter;
import com.moringaschool.live_cleanliness.adapters.ProductAdapter;

public class FragmentInstallProduct extends Fragment {

    View v;
    ListView listView;
    ArrayAdapter<InstallationDetails> mAdapter;
    private String[] sTitle = {"Basic electrician daily labor","Painting daily labour","Air conditioner repair","Generator/inverter repair or installation"};
    private String[] onDescription = {" Hire a standard electrician for a day for basic electrical wiring or fixtures","9 hours of labor from an experienced painter under your supervision","Fix or install air conditioning equipment ","Installation, repair, or replacement of instant shower heate"};
    private int[] bssImages = {R.drawable.dairly,R.drawable.labour,R.drawable.aircond,R.drawable.invet};



    public FragmentInstallProduct(){

     }
     @Nullable
     @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstance){
         v=inflater.inflate(R.layout.product_fragment,container,false);

         listView =(ListView) v.findViewById(R.id.listProduct);

         ProductAdapter adapter = new  ProductAdapter(getActivity(),sTitle,onDescription,bssImages);
         listView.setAdapter(adapter);

         listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                 if (view==) {
                     Intent intent = new Intent(getContext(), InstallationDetailsOne.class);
                     startActivity(intent);
//                 }
             }
         });

         return v;
     }
}
