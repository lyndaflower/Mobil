package com.moringaschool.live_cleanliness.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.moringaschool.live_cleanliness.R;

public class PaintingAdapter extends BaseAdapter {
    Context context;
    private final String[] bssNames;
    private final int[] bssImage;
    View view;

    public PaintingAdapter(Context context, String[] bssNames, int[] bssImage) {
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
