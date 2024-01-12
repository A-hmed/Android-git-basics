package com.route.basicsc39;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SpalshActivity extends AppCompatActivity {
    Button startHomeBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh);
        Log.e("SpalshActivity", "Oncreate");
        startHomeBtn = findViewById(R.id.homeScreenBtn);
        startHomeBtn.setOnClickListener(view -> startHomeScreen());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("SpalshActivity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("SpalshActivity", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("SpalshActivity", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("SpalshActivity", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("SpalshActivity", "onDestroy");
    }

    private void startHomeScreen() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}