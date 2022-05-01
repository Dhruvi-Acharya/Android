package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    Button displayMsg,logbtn,imintent,btnRelative,btnCard,btnLife,btnFrg,btnSpin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        init();

        displayMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,DisplayMshActivity.class));
            }
        });

        logbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,LogActivity.class));
            }
        });

        imintent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,IntentActivity.class));
            }
        });

        btnRelative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,RelativeLayoutActivity.class));
            }
        });

        btnCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,CardviewActivity.class));
            }
        });


        btnLife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,LifecycleActivity.class));
            }
        });
        btnLife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,LifecycleActivity.class));
            }
        });


    }

    void init(){
        displayMsg=findViewById(R.id.display_msg);
        logbtn=findViewById(R.id.btn_log);
        imintent=findViewById(R.id.im_intent);
        btnRelative=findViewById(R.id.btn_relative);
        btnCard=findViewById(R.id.btn_card);
        btnLife=findViewById(R.id.btn_life);
        btnFrg=findViewById(R.id.btn_frg);
        btnSpin=findViewById(R.id.btn_spin);
    }

}