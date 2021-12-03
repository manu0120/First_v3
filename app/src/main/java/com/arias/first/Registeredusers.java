package com.arias.first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class Registeredusers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeredusers);

        ImageView mBack=findViewById(R.id.tvFondo);

        Glide.with(this)
                //load("https://images.unsplash.com/photo-1634733741165-685d61c6a206?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=730&q=80")
                //.load(R.drawable.girl)
                .load(R.drawable.users_background)
                .transition(DrawableTransitionOptions.withCrossFade(2000))
                .centerCrop()
                //.circleCrop()

                .into(mBack);
    }



}