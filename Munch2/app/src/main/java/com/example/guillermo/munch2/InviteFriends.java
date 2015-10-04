package com.example.guillermo.munch2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class InviteFriends extends AppCompatActivity {

    private android.support.v7.widget.Toolbar toolbar;
    public void enviar(View v){
        Intent it = new Intent(this,payment_method.class);
        startActivity(it);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_friends);


        toolbar= (android.support.v7.widget.Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
    }
}
