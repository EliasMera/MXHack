package com.example.guillermo.munch2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class payment_method extends AppCompatActivity {

    private android.support.v7.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_method);

        toolbar= (android.support.v7.widget.Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

    }
    public void friends(View v){
        Intent i = new Intent(this,FriendList.class);
        startActivity(i);

    }
    public void regresar(View v){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
