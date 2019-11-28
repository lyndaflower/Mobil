package com.moringaschool.live_cleanliness;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import com.moringaschool.live_cleanliness.adapters.InstallationAdapter;

public class InstallationActivity extends AppCompatActivity {
String [] bssName={"Yogi IT Services"};
int[] bssImage={R.drawable.yogi};
    GridView businessGrid;
    TextView bssesName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_installation);
        businessGrid=findViewById(R.id.installation_bss);
bssesName=findViewById(R.id.fragInstall);
        InstallationAdapter installationAdapter=new InstallationAdapter(this,bssName,bssImage);

        businessGrid.setAdapter(installationAdapter);

    }
}
