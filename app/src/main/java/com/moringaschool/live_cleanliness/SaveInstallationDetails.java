package com.moringaschool.live_cleanliness;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.text.TextUtils;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.live_cleanliness.Models.InstallationCustomer;

import java.util.Date;
import java.util.List;

public class SaveInstallationDetails extends AppCompatActivity {
    FirebaseAuth auth;
    FirebaseDatabase database;
    DatabaseReference installation;
    List<InstallationCustomer> installationCustomers;
    TextView location;
    TextView description;
    TextView timeToBeDone;
    TextView whatItIs;
    Button saveData;
    String locationInst;
    String descInst;
    Date timeTobeDoneInst=new Date();
    String whatItIsInst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_installation_details);
        auth = FirebaseAuth.getInstance();
        installation = FirebaseDatabase.getInstance().getReference("Installations");
        location = findViewById(R.id.a);
        description = findViewById(R.id.b);
        timeToBeDone = findViewById(R.id.c);
        whatItIs = findViewById(R.id.d);
        saveData = findViewById(R.id.button);

        saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                installInfo();
            }
        });
    }



    private void installInfo(){
  locationInst=location.getText().toString();
  descInst=description.getText().toString();
  whatItIsInst=whatItIs.getText().toString();
  String id=installation.push().getKey();




//        InstallationCustomer installationCustomer=new InstallationCustomer(locationInst,descInst,whatItIsInst,timeTobeDoneInst,id);
//        installation.child(id).setValue(installationCustomer);

        Toast.makeText(this, "Successfully Sent", Toast.LENGTH_SHORT).show();
    }


}
