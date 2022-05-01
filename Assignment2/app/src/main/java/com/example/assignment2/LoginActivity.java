package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity {

    EditText email, pwd;
    Button loginBtn;
    DatabaseHelper databaseHelper;
    LinearLayout ll;
    TextView signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginBtn = findViewById(R.id.btn_login);
        ll = findViewById(R.id.ll_login);
        signup = findViewById(R.id.tv_signup);

        databaseHelper = new DatabaseHelper(this);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = findViewById(R.id.et_email);
                pwd = findViewById(R.id.et_pwd);

                if (databaseHelper.checkUser(email.getText().toString(), pwd.getText().toString())) {
                    Intent accountsIntent = new Intent(LoginActivity.this, HomeActivity.class);
                    accountsIntent.putExtra("EMAIL", email.getText().toString().trim());
                    email.setText(null);
                    pwd.setText("");
                    startActivity(accountsIntent);
                    finish();
                } else {
                    // Snack Bar to show success message that record is wrong
                    Snackbar.make(ll, "Entered Details is incorrect", Snackbar.LENGTH_LONG).show();
                }

            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(i);
            }
        });
    }
}