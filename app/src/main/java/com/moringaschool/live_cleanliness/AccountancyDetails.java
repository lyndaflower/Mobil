package com.moringaschool.live_cleanliness;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageTask;
import com.moringaschool.live_cleanliness.Models.InstallationCustomer;
import com.moringaschool.live_cleanliness.networks.PostgresqlAPI;
import com.moringaschool.live_cleanliness.networks.PostgresqlApiUse;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.moringaschool.live_cleanliness.Constants.POSTGRESQL_BASE_URL;

public class AccountancyDetails extends AppCompatActivity {
    private PostgresqlAPI postgresqlAPI;
    String name;
    String phone;
    String email;
    String location;
    String time;
    String service;
    List<InstallationCustomer> installDetails = new ArrayList<>();
    DatabaseReference mDatabaseRef;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private StorageTask uploadTask;
    private CardView cardUser;
    private Button sendDetails;
    private EditText nameService;
    private EditText userPhone;
    private EditText userEmail;
    private EditText userLocation;
    private TextView timeService;
    private EditText userService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountancy_details);
        sendDetails=findViewById(R.id.buttonSend);
        nameService=findViewById(R.id.a);
        userPhone=findViewById(R.id.b);
        userEmail=findViewById(R.id.c);
        userLocation=findViewById(R.id.d);
        timeService=findViewById(R.id.e);
        userService=findViewById(R.id.f);
        mAuth = FirebaseAuth.getInstance();
        mDatabaseRef= FirebaseDatabase.getInstance().getReference("Accountancy").child("AccountancyRequest");
//        Intent clean=getIntent();
//        String a=clean.getStringExtra("Installation");

        Retrofit retrofit=new Retrofit.Builder().baseUrl(POSTGRESQL_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        postgresqlAPI=retrofit.create(PostgresqlAPI.class);
        createPost();
        sendDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addServiceDetails();
                Intent intent=new Intent(AccountancyDetails.this,RegisterBusiness.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mDatabaseRef.addValueEventListener(new ValueEventListener(){


            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                installDetails.clear();

                for (DataSnapshot userSnap : dataSnapshot.getChildren()) {

                    InstallationCustomer customer = userSnap.getValue(InstallationCustomer.class);
                    installDetails.add(customer);

                }
//                OurUsers adapter = new OurUsers(UserUpload.this, ourUsers);
//
//                userList.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });
    }

    private void createPost(){
        PostgresqlApiUse postgresqlClient=new PostgresqlApiUse("Beauty",1);

    }

    private  void  addServiceDetails(){
        name=nameService.getText().toString();
        phone= userPhone.getText().toString();
        email=userEmail.getText().toString();
        location=userLocation.getText().toString();
        service=userService.getText().toString();
        Calendar getDate = Calendar.getInstance();
        time= DateFormat.getDateInstance(DateFormat.FULL).format(getDate.getTime());
        timeService= findViewById(R.id.e);

        timeService.setText(time);
        System.out.println(time);
        System.out.println(timeService);
        if (!TextUtils.isEmpty(location)){

            String id=mDatabaseRef.push().getKey();
            InstallationCustomer install=new InstallationCustomer(name,phone,email,location,time,service);
            mDatabaseRef.child(id).setValue(install);
            Toast.makeText(this, "Well Received", Toast.LENGTH_SHORT).show();
        }
        else {

            Toast.makeText(this, "Enter your Email please!", Toast.LENGTH_SHORT).show();
        }

    }
}
