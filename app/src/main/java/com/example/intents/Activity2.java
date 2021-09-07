package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    TextView tvWishUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        tvWishUser = findViewById(R.id.tvWIshUser);
        String name = getIntent().getStringExtra("name").toString();
        tvWishUser.setText(name +" , Welcome to Activity 2");

    }
}