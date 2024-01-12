package com.route.basicsc39;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        Log.e("LoginActivity", "on create");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("LoginActivity", "on start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("LoginActivity", "on resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("LoginActivity", "on pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("LoginActivity", "on stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("LoginActivity", "on destroy");
    }
}
