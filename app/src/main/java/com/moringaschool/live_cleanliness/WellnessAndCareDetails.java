package com.moringaschool.live_cleanliness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.moringaschool.live_cleanliness.adapters.ViewPagerAdapter;
import com.moringaschool.live_cleanliness.tabs.FragmentPaintDetail;
import com.moringaschool.live_cleanliness.tabs.FragmentPaintPro;
import com.moringaschool.live_cleanliness.tabs.FragmentPaintReview;
import com.moringaschool.live_cleanliness.tabs.FragmentWellness;

public class WellnessAndCareDetails extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellness_and_care_details);

        tabLayout=(TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager)findViewById(R.id.viewpager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());


        adapter.AddFragment(new FragmentPaintPro(),"Product");
        adapter.AddFragment(new FragmentWellness(),"How it work");
        adapter.AddFragment(new FragmentPaintReview(),"Reviews");


        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
    }
