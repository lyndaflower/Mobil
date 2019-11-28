package com.moringaschool.live_cleanliness.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.moringaschool.live_cleanliness.R;

public class ProductAdapter extends BaseAdapter {
    Context context;
    String[] title;
    String[] description;
    int[] picture;
    View view;
    public ProductAdapter(Context context,String [] onTitle, String[] onDescript, int [] mPicture){
        this.context = context;
        this.title = onTitle;
        this.description = onDescript;
        this.picture = mPicture;
    }


    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public Object getItem(int position) {
        return title[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.productout, null);


        ImageView mPicture=(ImageView) convertView.findViewById(R.id.imageV);
        TextView  onDescript=(TextView) convertView.findViewById(R.id.maintitle);
        TextView onTitle = (TextView) convertView.findViewById(R.id.descr);

        mPicture.setImageResource(picture[position]);
        onDescript.setText(title[position]);
        onTitle.setText(description[position]);
        }
        return convertView;
    }
}
