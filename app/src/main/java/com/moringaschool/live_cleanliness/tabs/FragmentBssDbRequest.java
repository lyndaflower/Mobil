package com.moringaschool.live_cleanliness.tabs;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.moringaschool.live_cleanliness.InstallationDetailsOne;
import com.moringaschool.live_cleanliness.Models.InstallationCustomer;
import com.moringaschool.live_cleanliness.R;


public class FragmentBssDbRequest extends Fragment {


private  View businessRequestView;
private RecyclerView myBssRequestList;
private DatabaseReference userRequestRef,usersRef;
private  FirebaseAuth mAuth;
private String currentUserId;
    public FragmentBssDbRequest() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
   businessRequestView=inflater.inflate(R.layout.fragment_fragment_bss_db_request,container,false);


   myBssRequestList=(RecyclerView) businessRequestView.findViewById(R.id.UserRequestList);
myBssRequestList.setLayoutManager( new LinearLayoutManager(getContext()));

mAuth=FirebaseAuth.getInstance();
currentUserId=mAuth.getCurrentUser().getUid();


userRequestRef=FirebaseDatabase.getInstance().getReference("Installation");


   return  businessRequestView;
    }

    @Override
    public void onStart() {
        super.onStart();

        FirebaseRecyclerOptions options=new  FirebaseRecyclerOptions.Builder<InstallationCustomer>()
.setQuery(userRequestRef,InstallationCustomer.class)
        .build();

        FirebaseRecyclerAdapter<InstallationCustomer,UserRquestViewHolder> adapter
                =new
                FirebaseRecyclerAdapter<InstallationCustomer, UserRquestViewHolder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull final UserRquestViewHolder holder, int i, @NonNull InstallationCustomer installationCustomer)
                    {


String userIDs=getRef(i).getKey();


userRequestRef.child(userIDs).addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

//        if (dataSnapshot.hasChild("name")){

            String name=dataSnapshot.getValue().toString();
           String phone=dataSnapshot.getValue().toString();
            String email=dataSnapshot.getValue().toString();
            String location=dataSnapshot.getValue().toString();
            String time=dataSnapshot.getValue().toString();
            String service=dataSnapshot.getValue().toString();

            holder.username.setText(name);
            holder.userphone.setText(phone);
            holder.useremail.setText(email);
            holder.userlocation.setText(location);
            holder.usertime.setText(time);
            holder.userservice.setText(service);
//        }
//else {
//            int phone=dataSnapshot.getValue().hashCode();
//            String email=dataSnapshot.getValue().toString();
//            String location=dataSnapshot.getValue().toString();
//            String time=dataSnapshot.getValue().toString();
//            String service=dataSnapshot.getValue().toString();
//
////            holder.username.setText(name);
//            holder.userphone.setText(phone+"\n");
//            holder.useremail.setText(email);
//            holder.userlocation.setText(location);
//            holder.usertime.setText(time);
//            holder.userservice.setText(service);

//        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
});

                    }

                    @NonNull
                    @Override
                    public UserRquestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.usersrequestview, parent, false);

                        UserRquestViewHolder viewHolder = new UserRquestViewHolder(view);
                        return viewHolder;
                    }
                };

myBssRequestList.setAdapter(adapter);
adapter.startListening();
//
//        myBssRequestList.OnClickListener(new AdapterView.OnItemClickListener() {
//        @Override
//        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//            Intent intent = new Intent(getContext(), InstallationDetailsOne.class);
//            startActivity(intent);
//
//        }
//    });

    }
public static  class  UserRquestViewHolder extends RecyclerView.ViewHolder{

    TextView username;
TextView userphone;
    TextView  useremail;
    TextView  userlocation;
    TextView usertime;
    TextView  userservice;


    public UserRquestViewHolder(@NonNull View itemView) {
        super(itemView);
        username=itemView.findViewById(R.id.a);
        userphone=itemView.findViewById(R.id.b);
        useremail=itemView.findViewById(R.id.c);
        userlocation=itemView.findViewById(R.id.d);
        usertime=itemView.findViewById(R.id.e);
        userservice=itemView.findViewById(R.id.f);

    }

    @Override
    public String toString() {
        return super.toString();
    }
}



}




