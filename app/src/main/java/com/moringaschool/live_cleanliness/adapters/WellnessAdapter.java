package com.moringaschool.live_cleanliness.adapters;

import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.moringaschool.live_cleanliness.Models.InstallationCustomer;
import com.moringaschool.live_cleanliness.R;
import com.moringaschool.live_cleanliness.fragments.InstallationFragment;

public class WellnessAdapter extends BaseAdapter {
    Context context;
    private final String[] bssNames;
    private final int[] bssImage;


    public WellnessAdapter(Context context, String[] bssNames, int[] bssImage) {
        this.context = context;
        this.bssNames = bssNames;
        this.bssImage = bssImage;
    }

    @Override
    public int getCount() {
        return bssNames.length;
    }

    @Override
    public Object getItem(int position) {
        return bssNames[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.single_install_bss, null);

        }
        ImageView bssImageView=(ImageView) convertView.findViewById(R.id.bssImage);
        TextView bssNameView=(TextView) convertView.findViewById(R.id.bssName);
        bssImageView.setImageResource(bssImage[position]);
        bssNameView.setText(bssNames[position]);
        return convertView;
    }
}
