package com.example.android.muhammadsubhanalazmi_1202150012_modul3;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView splash = findViewById(R.id.View);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //melakukan perpindahan activity pada activity login
                startActivity(new Intent(getApplicationContext(), login.class));
                finish();
            }
        },3000L); //timer untuk splash
    }
}
