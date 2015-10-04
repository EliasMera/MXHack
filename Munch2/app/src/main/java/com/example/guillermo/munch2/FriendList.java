package com.example.guillermo.munch2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class FriendList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_list);


    }
    public void regresar(View v){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
    public void pagos(View v){
        Intent i = new Intent(this,payment_method.class);
        startActivity(i);
    }
}
