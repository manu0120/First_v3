package com.arias.first;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class splash_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        openApp(true);

        ImageView fan = (ImageView) findViewById(R.id.logosplash);
        Animation myanim= AnimationUtils.loadAnimation(this, R.anim.fadein);
        fan.startAnimation(myanim);

        //glide for loading girls

    }

    /*
    public void onClick(View v) {
        Intent intent=new Intent (splash_screen.this, LoginActivity.class);
        startActivity(intent);
    }
    */

    private void openApp(boolean locationPermission){
        //Handler: hace q1ue se retrase una accion
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run(){
                Intent intent = new Intent(splash_screen.this, LoginActivity.class);
                startActivity(intent);
            }
            }, 2000);
    }
}