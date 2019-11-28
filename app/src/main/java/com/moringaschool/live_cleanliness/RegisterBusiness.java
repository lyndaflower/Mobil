package com.moringaschool.live_cleanliness;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.moringaschool.live_cleanliness.Models.Business;
import com.moringaschool.live_cleanliness.Models.InstallationCustomer;

import java.util.ArrayList;
import java.util.List;

public class RegisterBusiness extends AppCompatActivity implements View.OnClickListener{

    private EditText bussName;
    private EditText bussEmail;
    private EditText bussLocation;
    private Button mButtonRegister;

    Button btnRegister;
    String bssName;
    String bssEmail;
    String bssLocation;
    List<Business> business = new ArrayList<>();
    DatabaseReference mDatabaseRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_business);

        mButtonRegister =(Button)findViewById(R.id.buttonRegister);

         bussName=findViewById(R.id.bussName);
         bussEmail=findViewById(R.id.bussEmail);
         bussLocation=findViewById(R.id.bussLocation);
        mDatabaseRef= FirebaseDatabase.getInstance().getReference("Business");
btnRegister=findViewById(R.id.buttonRegister);
btnRegister.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        addBusiness();
    }
});

    }
    private  void addBusiness(){
        bssName=bussName.getText().toString();
        bssEmail=bussEmail.getText().toString();
        bssLocation=bussLocation.getText().toString();


        if (!TextUtils.isEmpty(bssLocation)){

            String id=mDatabaseRef.push().getKey();
            Business install=new Business(bssName,bssEmail,bssLocation);
            mDatabaseRef.child(id).setValue(install);
            Toast.makeText(this, "Business Added", Toast.LENGTH_SHORT).show();
        }
        else {

            Toast.makeText(this, "Enter  Location", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        mDatabaseRef.addValueEventListener(new ValueEventListener(){


            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                business.clear();

                for (DataSnapshot userSnap : dataSnapshot.getChildren()) {

                    Business customer = userSnap.getValue(Business.class);
                    business.add(customer);

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

    @Override
    public void onClick(View v) {
//        if (v == mButtonRegister){
//            Intent intent = new Intent(RegisterBusiness.this,.class);
//            startActivity(intent);
//        }
    }
}
