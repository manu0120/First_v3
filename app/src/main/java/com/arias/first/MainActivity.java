package com.arias.first;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private SwipeRefreshLayout swipeLayout;
    private WebView miVisorWeb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //las dos lineas de abajo estaban comentadas (para cuando no se quiera usar el ContextMenu)
        /*TextView mycontext= (TextView) findViewById(R.id.textTap);
        registerForContextMenu(mycontext);*/

        //asignar a swipelayout y mivisorWeb el control diseñado en el layout
        /*
        cast al layout SwipeRefresh con el que rodeamos la vista en el
        xml y le colocamos un listener
         */
        swipeLayout = findViewById(R.id.myswipe);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);

        //la vista dentro es un WebView con permiso para zoom
        miVisorWeb=(WebView) findViewById(R.id.vistaweb);
        miVisorWeb.getSettings().setBuiltInZoomControls(true);
        miVisorWeb.loadUrl("https://thispersondoesnotexist.com");

    }

    public void showAlertDialogButtonClicked(MainActivity mainActivity){
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);

     //el dialogo estandar tiene título/icono pero podemos sustituirlo por un XML a medida
        builder.setTitle("Achtung!");
        builder.setMessage("Where do you go?");
        builder.setIcon(R.drawable.ic_settings);
        builder.setCancelable(false);
        // un XML a medida para el diálogo
//        builder.setView(getLayoutInflater().inflate(R.layout.alertdialog_view, null));

        // add the buttons
        builder.setPositiveButton("Signup", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // do something like...
                Intent intent = new Intent(MainActivity.this, Signup.class);
                startActivity(intent);
                dialog.dismiss();

            }
        });
        builder.setNegativeButton("Login", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                // do something like...
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);

                dialog.dismiss();
            }
        });
        builder.setNeutralButton("Other", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                // do something like...

                dialog.dismiss();
            }
        });
        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    protected SwipeRefreshLayout.OnRefreshListener
            mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {


            Toast toast0 = Toast.makeText(MainActivity.this, "Hi there! I don't exist :)", Toast.LENGTH_LONG);
            toast0.show();
            miVisorWeb.reload();
            swipeLayout.setRefreshing(false);
        }
    };

    //método que se usa para crear el menú
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {

        //getMenuInflater().inflate(R.menu.menu_context, menu);

        //las tres lineas de abajo estaban comentadas (si no se quiere usar el ContextMenu)
        /*super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);*/
    }

    //metodo que se usa para responder a los eventos de las opciones
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.item1:
                /*
                Toast toast=Toast.makeText(this, "Item copied", Toast.LENGTH_LONG);
                toast.show();
                return true;
                */
                /* myMainConstraint: id del layout de activity_main.xml */
                final ConstraintLayout mLayout =  findViewById(R.id.myMainConstraint);

                Snackbar snackbar = Snackbar
                        .make(mLayout, "fancy a Snack while you refresh?", Snackbar.LENGTH_LONG)

                        .setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Snackbar snackbar1 = Snackbar.make(mLayout, "Action is restored!", Snackbar.LENGTH_SHORT);
                                snackbar1.show();
                            }
                        });

                snackbar.show();


                return true;
            case R.id.item2:
                Toast toast2=Toast.makeText(this, "Downloading", Toast.LENGTH_LONG);
                toast2.show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }

    }

    //asociar el codigo xml con la barra de arriba
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_appbar, menu);
        return true;
    }

    //metodo que le da vida a las entradas de menú
    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();

        if (id == R.id.item1) {
            Toast toast = Toast.makeText(this, "Infecting", Toast.LENGTH_LONG);
            toast.show();

        }
        if (id == R.id.item2) {
            Toast toast = Toast.makeText(this, "Fixing", Toast.LENGTH_LONG);
            toast.show();
        }
        if (id == R.id.item4){
            showAlertDialogButtonClicked(MainActivity.this);
        }
        if (id == R.id.item5){
            Intent intent = new Intent(MainActivity.this, Registeredusers.class);
            startActivity(intent);
        }
        if (id == R.id.item6){
            Intent intent = new Intent(MainActivity.this, BotAppBar.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);

    }


}




















