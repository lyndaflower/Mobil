package com.moringaschool.live_cleanliness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.moringaschool.live_cleanliness.adapters.BssDashBoardViewPagerAdapter;
import com.moringaschool.live_cleanliness.adapters.ViewPagerAdapter;
import com.moringaschool.live_cleanliness.tabs.FragmentBssDbRequest;
import com.moringaschool.live_cleanliness.tabs.FragmentInstallProduct;
import com.moringaschool.live_cleanliness.tabs.FragmentInstallWorks;
import com.moringaschool.live_cleanliness.tabs.FragmentInstallReview;

public class BusinessDashBoard extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private BssDashBoardViewPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_dash_board);
        tabLayout=(TabLayout) findViewById(R.id.tablayoutBusDash);
        viewPager = (ViewPager)findViewById(R.id.viewPagerDash);

        BssDashBoardViewPagerAdapter adapter = new BssDashBoardViewPagerAdapter(getSupportFragmentManager());


        adapter.AddFragment(new FragmentBssDbRequest(),"Customer request");
        adapter.AddFragment(new FragmentBssDbRequest(),"Business Reply");
        adapter.AddFragment(new FragmentBssDbRequest(),"Feedback");


        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

//
//        Intent clean=getIntent();
//        String a=clean.getStringExtra("Installation");

}