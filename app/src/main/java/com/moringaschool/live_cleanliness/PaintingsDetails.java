package com.moringaschool.live_cleanliness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.moringaschool.live_cleanliness.adapters.ViewPagerAdapter;
import com.moringaschool.live_cleanliness.tabs.FragmentInstallProduct;
import com.moringaschool.live_cleanliness.tabs.FragmentInstallWorks;
import com.moringaschool.live_cleanliness.tabs.FragmentInstallReview;
import com.moringaschool.live_cleanliness.tabs.FragmentPaintDetail;
import com.moringaschool.live_cleanliness.tabs.FragmentPaintPro;
import com.moringaschool.live_cleanliness.tabs.FragmentPaintReview;

public class PaintingsDetails extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paintings_details);

        tabLayout=(TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager)findViewById(R.id.viewpager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());


        adapter.AddFragment(new FragmentPaintPro(),"Product");
        adapter.AddFragment(new FragmentPaintDetail(),"How it works");
        adapter.AddFragment(new FragmentPaintReview(),"Reviews");


        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    }
