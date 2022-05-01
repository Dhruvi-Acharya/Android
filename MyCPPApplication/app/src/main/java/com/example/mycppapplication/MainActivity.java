package com.example.mycppapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mycppapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'mycppapplication' library on application startup.
    static {
        System.loadLibrary("mycppapplication");
    }

    private ActivityMainBinding binding;
    Button btnJNI, btnJNIStringArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Example of a call to a native method
        TextView tv = binding.sampleText;
        tv.setText(stringFromJNI());

        btnJNI = findViewById(R.id.btnJni);
        btnJNIStringArray = findViewById(R.id.btnJniStringArray);

        btnJNI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = sendYourName("Dhruvi", "Acharya");
                Toast.makeText(getApplicationContext(), "Result from JNI is " + result,
                        Toast.LENGTH_LONG).show();
            
            }
        });

        btnJNIStringArray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] strings = stringArrayFromJNI();
                Toast.makeText(getApplicationContext(), "First element is "+strings[0],
                        Toast.LENGTH_LONG).show();
            }
        });
    }



    /**
     * A native method that is implemented by the 'mycppapplication' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
    public native String sendYourName(String firstName, String lastName);
    public native String[] stringArrayFromJNI();
}