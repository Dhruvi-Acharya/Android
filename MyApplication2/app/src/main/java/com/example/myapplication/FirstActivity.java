package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class FirstActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    LinearLayout ll;
    TextView tv;
    Button b;
    Spinner s;
    String[] bank = {"SBI", "BOI", "AXIS"};
    ListView lv;
    String[] country = {"India","China","USA"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        ll = findViewById(R.id.linear1);
        b = findViewById(R.id.btn1);
        tv = findViewById(R.id.tv1);
        s = findViewById(R.id.spin_item);
        s.setOnItemSelectedListener(this);
        lv = findViewById(R.id.list_view);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(getApplicationContext(),"Button clicked",Toast.LENGTH_LONG).show();
                Snackbar s = Snackbar.make(ll, "Button clicked", Snackbar.LENGTH_INDEFINITE); //indefinite time
                s.setAction("Cancel", new View.OnClickListener() { //cancel snackbar
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(), "cancel clicked", Toast.LENGTH_LONG).show();
                    }
                });
                //s.setActionTextColor();
                s.show();

            }
        });

        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, bank);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(aa);

        ArrayAdapter<String> aac = new ArrayAdapter<>(this,R.layout.activity_listview,R.id.textView,country);
        lv.setAdapter(aac);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getApplicationContext(), bank[i], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}