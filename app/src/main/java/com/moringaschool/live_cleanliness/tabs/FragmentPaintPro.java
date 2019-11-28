package com.moringaschool.live_cleanliness.tabs;

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
import com.moringaschool.live_cleanliness.R;
import com.moringaschool.live_cleanliness.adapters.ProductAdapter;

public class FragmentPaintPro extends Fragment {

    View v;
    ListView listview;
    ArrayAdapter<InstallationDetails> mAdapter;
    private String[] sTitle = {"Recurring fitness","Cardio sculpting","Manicure & pedicure","Massage"};
    private String[] onDescription = {" Hire a standard electrician for a day for basic electrical wiring or fixtures","9 hours of labor from an experienced painter under your supervision","Fix or install air conditioning equipment ","Installation, repair, or replacement of instant shower heate"};
    private int[] bssImages = {R.drawable.care3,R.drawable.strechin,R.drawable.nail,R.drawable.massage};

    public FragmentPaintPro(){

     }
     @Nullable
     @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstance){
         v=inflater.inflate(R.layout.fragment_paintproduct,container,false);
         listview =(ListView) v.findViewById(R.id.listWel);

         ProductAdapter adapter = new   ProductAdapter(getActivity(),sTitle,onDescription,bssImages);
         listview.setAdapter(adapter);

         listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



             }
         });
         return v;
     }
}
