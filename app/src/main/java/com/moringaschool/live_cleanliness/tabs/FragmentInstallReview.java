package com.moringaschool.live_cleanliness.tabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.moringaschool.live_cleanliness.R;

public class FragmentInstallReview extends Fragment {
    View v;

    public FragmentInstallReview(){

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstance){
        v=inflater.inflate(R.layout.installreview_fragment,container,false);
        return v;
    }
}
