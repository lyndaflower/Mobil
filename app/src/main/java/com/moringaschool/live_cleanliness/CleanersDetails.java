package com.moringaschool.live_cleanliness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.moringaschool.live_cleanliness.adapters.ViewPagerAdapter;
import com.moringaschool.live_cleanliness.tabs.FragmentCleanWork;
import com.moringaschool.live_cleanliness.tabs.FragmentCleaner;
import com.moringaschool.live_cleanliness.tabs.FragmentExplore;
import com.moringaschool.live_cleanliness.tabs.FragmentCleanWork;

public class CleanersDetails extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cleaners_details);

        tabLayout=(TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager)findViewById(R.id.viewpager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());


        adapter.AddFragment(new FragmentCleaner(),"Product");
        adapter.AddFragment(new FragmentCleanWork(),"How it works");
        adapter.AddFragment(new FragmentExplore(),"Reviews");


        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
    }
