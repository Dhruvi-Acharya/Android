package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class DisplayMshActivity extends AppCompatActivity {
    Button t,s,s2;
    LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_msh);

        t=findViewById(R.id.btn_toast);
        s=findViewById(R.id.btn_snack);
        s2=findViewById(R.id.btn_snack2);
        ll=findViewById(R.id.llMsg);

        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Toast Message",Toast.LENGTH_LONG).show();
            }
        });

        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar s = Snackbar.make(ll,"Snackbar Message",Snackbar.LENGTH_LONG);
                s.show();
            }
        });

        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar=Snackbar.make(ll,"Message",Snackbar.LENGTH_INDEFINITE)
                        .setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
//Code
                            }
                        });
                snackbar.setActionTextColor(Color.GREEN);
                snackbar.show();
            }
        });


    }
}