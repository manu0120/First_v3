package com.arias.first;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;

public class BotAppBar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_app_bar);
        //cast al xml
        BottomAppBar bottomappbar = findViewById(R.id.bottomAppBar);
        //click event en el FAB
        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BotAppBar.this, "FAB Clicked", Toast.LENGTH_LONG).show();
            }
        });
        //click event en el Hamburguer menu
        bottomappbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BotAppBar.this, "Menu Clicked", Toast.LENGTH_LONG).show();
            }
        });

        //click event en el bottonBar menu item
        bottomappbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch(item.getItemId()){
                    case R.id.extension:
                        Toast.makeText(BotAppBar.this,"Accediendo a las extensiones", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.search:
                        Toast.makeText(BotAppBar.this,"Search", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.send:
                        Toast.makeText(BotAppBar.this,"Send", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
    }
}