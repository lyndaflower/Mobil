package com.moringaschool.live_cleanliness.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.moringaschool.live_cleanliness.Models.InstallationCustomer;
import com.moringaschool.live_cleanliness.R;

import java.util.List;

public class HowworksAdapter extends BaseAdapter {

        Context context;
        String[] bssNames;
        String[] bssName;
      int[] bssImage;
        View view;

    public HowworksAdapter(Context context, String[] bssNames, String[] bssName2, int[] bssImage) {
        this.context = context;
        this.bssNames = bssNames;
        this.bssImage = bssImage;
        this.bssName = bssName2;
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
            convertView = inflater.inflate(R.layout.installout, null);

        }
        ImageView bssImageView=(ImageView) convertView.findViewById(R.id.imageview);
        TextView bssNameView=(TextView) convertView.findViewById(R.id.textview1);
        TextView bssName2 = (TextView) convertView.findViewById(R.id.textview2);

        bssImageView.setImageResource(bssImage[position]);
        bssNameView.setText(bssNames[position]);
        bssName2.setText(bssName[position]);

        return convertView;
    }
}