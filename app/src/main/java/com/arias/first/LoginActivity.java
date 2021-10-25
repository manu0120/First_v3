package com.arias.first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

/**
 * @author manu0120sp
 */
//Segundo comentario

public class LoginActivity extends AppCompatActivity {

    @Override
    //metodo que crea el login con su contenido y su vista
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    //glide for loading girls
    ImageView mGirl=findViewById(R.id.girl);

    Glide.with(this)
            .load("https://images.unsplash.com/photo-1634733741165-685d61c6a206?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=730&q=80")
            //.load(R.drawable.girl)
            .transition(DrawableTransitionOptions.withCrossFade(2000))
            //.centerCrop()
            //.circleCrop()

            .into(mGirl);
    }

    public void onClick(View v) {
        Intent intent=new Intent (LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void openMain(View v){
        Intent intent=new Intent(LoginActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public void openSignup(View v){
        Intent intent=new Intent(LoginActivity.this,Signup.class);
        startActivity(intent);
    }
}