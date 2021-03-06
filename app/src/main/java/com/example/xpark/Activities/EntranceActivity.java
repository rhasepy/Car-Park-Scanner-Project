package com.example.xpark.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.xpark.R;

public class EntranceActivity extends AppCompatActivity {

    private Button signin;
    private Button signup;
    private Button map;
    private Button qr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrance);

        signin = findViewById(R.id.sign_in_enter);
        signup = findViewById(R.id.sign_up_enter);
        map = findViewById(R.id.map_enter);
        qr = findViewById(R.id.qrCode_enter);

        signin.setOnClickListener( view -> {
            Intent intent = new Intent(this, LoginActivity.class);
            this.startActivity(intent);
        });

        signup.setOnClickListener(view -> {
            Intent intent = new Intent(this, SignUpActivity.class);
            this.startActivity(intent);
        });

        map.setOnClickListener(view ->  {
            Intent intent = new Intent(this, MapsActivity.class);
            this.startActivity(intent);
        });

        qr.setOnClickListener(view -> {
            Intent intent = new Intent(this, QRActivity.class);
            this.startActivity(intent);
        });
    }
}