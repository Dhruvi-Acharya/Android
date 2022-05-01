package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnerActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner s;
    String[] bank = {"SBI", "BOI", "AXIS"};
    ListView lv;
    String[] country = {"India","China","USA","India","China","USA","India","China","USA"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        s = findViewById(R.id.spin_item);
        s.setOnItemSelectedListener(this);
        lv = findViewById(R.id.list_view);

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