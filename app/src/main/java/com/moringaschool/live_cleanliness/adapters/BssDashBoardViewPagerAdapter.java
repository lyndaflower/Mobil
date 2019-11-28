package com.moringaschool.live_cleanliness.adapters;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class BssDashBoardViewPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> lstFragmentDash = new ArrayList<>();
    private final List<String> lstTitlesDash = new ArrayList<>();


    public BssDashBoardViewPagerAdapter(FragmentManager fm) {
        super(fm);

    }
    @Override
    public Fragment getItem(int position) {
        return lstFragmentDash.get(position);
    }

    @Override
    public int getCount() {
        return lstTitlesDash.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return lstTitlesDash.get(position);
    }

    public void AddFragment(Fragment fragment, String Title) {
        lstFragmentDash.add(fragment);
        lstTitlesDash.add(Title);

    }

}
