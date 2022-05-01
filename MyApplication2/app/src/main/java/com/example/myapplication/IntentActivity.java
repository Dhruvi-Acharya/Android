package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class IntentActivity extends AppCompatActivity {

    Button btn,btn_text;
    ImageButton ib,dial,mail;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
        setTitle("Intent Page");

        btn = findViewById(R.id.btn_google);
        btn_text = findViewById(R.id.btn_sendText);
        ib = findViewById(R.id.btn_img);
        et = findViewById(R.id.message);
        dial = findViewById(R.id.btn_dial);
        mail = findViewById(R.id.btn_gmail);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://www.google.com"));
                startActivity(i);
            }
        });

        btn_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String msg = "Hello....\nWelcome to eInfochips";
                String msg = et.getText().toString();
                Intent i = new Intent(Intent.ACTION_SEND); // setting type action send
                i.setType("text/plain"); // setting type of intent
                i.putExtra(Intent.EXTRA_TEXT,msg);
                //i.setPackage("com.whatsapp");
                startActivity(Intent.createChooser(i,"Suggest to your friends...")); //choosing app related to that in this the app who accept text they all are getting displayed
                et.setText("");
            }
        });

        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = "Hello....\nWelcome to eInfochips";
                Intent i = new Intent(Intent.ACTION_SEND); // setting type action send
                i.setType("text/plain"); // setting type of intent
                i.putExtra(Intent.EXTRA_TEXT,msg);
                i.setPackage("com.whatsapp"); // send only in whatsapp no other application will be shown
                startActivity(Intent.createChooser(i,"Suggest to your friends..."));
            }
        });

        dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String phone = "+1234567891";
//                Intent  i = new Intent(Intent.ACTION_DIAL,Uri.fromParts("tel",phone,null));
//                startActivity(i);

                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:"+et.getText().toString()));
                startActivity(i);
            }
        });

        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subject = "Demo";
                String message = "message";
                Intent m = new Intent(Intent.ACTION_SEND,Uri.parse("mailto:"));

                m.setType("message/rfc822");

                m.putExtra(Intent.EXTRA_EMAIL,"dhruvi@gmail.com");
                m.putExtra(Intent.EXTRA_SUBJECT,subject);
                m.putExtra(Intent.EXTRA_TEXT,message);

                startActivity(Intent.createChooser(m,"Choose an email client from..."));
            }
        });
    }
}