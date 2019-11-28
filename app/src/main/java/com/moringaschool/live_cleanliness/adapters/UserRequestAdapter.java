package com.moringaschool.live_cleanliness.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.moringaschool.live_cleanliness.Models.InstallationCustomer;
import com.moringaschool.live_cleanliness.R;

import java.util.List;

public class UserRequestAdapter extends ArrayAdapter<InstallationCustomer> {
    ListView allUsersRequest;
    private Context context;
    List<InstallationCustomer> ourUsersRequest;
    String [] name;
    int [] phone;
    String [] email;
    String [] location;
    String [] time;
    String [] service;

    public UserRequestAdapter( Context context,int pos, List<InstallationCustomer> ourUsersRequest, String[] name, int[] phone, String[] email, String[] location, String[] time, String[] service) {
        super(context,pos,ourUsersRequest);
        this.context = context;
        this.ourUsersRequest = ourUsersRequest;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.location = location;
        this.time = time;
        this.service = service;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listUserRequest= LayoutInflater.from(parent.getContext()).inflate(R.layout.usersrequestview,parent,false);
        TextView viewName=listUserRequest.findViewById(R.id.a);
        TextView viewPhone=listUserRequest.findViewById(R.id.b);
        TextView viewEmail=listUserRequest.findViewById(R.id.c);
        TextView viewLocation=listUserRequest.findViewById(R.id.d);
        TextView viewTime=listUserRequest.findViewById(R.id.e);
        TextView viewService=listUserRequest.findViewById(R.id.f);
        InstallationCustomer customer=ourUsersRequest.get(position);


        viewName.setText("CustomerName:"+customer.getName());
        viewPhone.setText("Customer Phone number:"+customer.getPhone());
        viewEmail.setText("Customer Email:"+customer.getEmail());
        viewLocation.setText("Where customer is:"+customer.getLocation());
        viewTime.setText("Time"+customer.getTime());
        viewService.setText("Request"+customer.getService());

return listUserRequest;
    }
}
