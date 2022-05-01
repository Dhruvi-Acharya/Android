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

public class SignUpActivity extends AppCompatActivity {
    EditText name, email, pwd;
    Button signup;
    TextView signin;

    LinearLayout signup_ll;
    DatabaseHelper databaseHelper;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name = findViewById(R.id.et_name);
        email = findViewById(R.id.etEmail);
        pwd = findViewById(R.id.et_password);
        signup = findViewById(R.id.btn_signup);
        signin = findViewById(R.id.tv_login);
        signup_ll = findViewById(R.id.ll_signup);

        databaseHelper = new DatabaseHelper(this);
        user = new User();

        signup.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
               /* user.setName(name.getText().toString().trim());
                user.setEmail(email.getText().toString().trim());
                user.setPassword(pwd.getText().toString().trim());

                Intent i = new Intent(SignUpActivity.this, HomeActivity.class);
                startActivity(i);

                databaseHelper.addUser(user);

                Snackbar.make(signup_ll, "Success", Snackbar.LENGTH_LONG).show();
                name.setText("");
                email.setText(null);
                pwd.setText("");*/

                if (!databaseHelper.checkUser(email.getText().toString().trim())) {
                    user.setName(name.getText().toString().trim());
                    user.setEmail(email.getText().toString().trim());
                    user.setPassword(pwd.getText().toString().trim());

                    databaseHelper.addUser(user);
                    // Snack Bar to show success message that record saved successfully
                    Snackbar.make(signup_ll, "Success", Snackbar.LENGTH_LONG).show();

                    Intent i = new Intent(SignUpActivity.this, HomeActivity.class);
                    i.putExtra("EMAIL", email.getText().toString().trim());

                    name.setText("");
                    email.setText(null);
                    pwd.setText("");

                    startActivity(i);
                    finish();

                } else {
                    // Snack Bar to show error message that record already exists
                    Snackbar.make(signup_ll, "Email already exists", Snackbar.LENGTH_LONG).show();
                }

//                Intent i = new Intent(SignUpActivity.this,MainActivity.class);
//                startActivity(i);
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
    }
}