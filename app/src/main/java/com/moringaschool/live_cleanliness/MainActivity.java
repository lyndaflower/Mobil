package com.moringaschool.live_cleanliness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private Button butBusiness;
private Button butUser;

    private ImageView image, leaf;
    private LinearLayout animText, texth, menus;
    private Animation frombottom;
    private Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        butBusiness = findViewById(R.id.business);

        image = (ImageView) findViewById(R.id.image);
        animText = (LinearLayout) findViewById(R.id.animText);
        texth = (LinearLayout) findViewById(R.id.explore);
//        menus = (LinearLayout) findViewById(R.id.menus);
        frombottom = AnimationUtils.loadAnimation(this, R.anim.anim);
        image.animate().translationY(-1900).setDuration(2000).setStartDelay(600);
        animText.animate().translationY(140).alpha(0).setDuration(1000).setStartDelay(600);

        texth.startAnimation(frombottom);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(this);
        butBusiness.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == button){
            Intent business= new Intent(MainActivity.this,LoginActivity.class);
            startActivity(business);
            finish();
        }
        if (v == butBusiness){
            Intent intent = new Intent(MainActivity.this,RegisterBusiness.class);
            startActivity(intent);
        }
        }
    }
