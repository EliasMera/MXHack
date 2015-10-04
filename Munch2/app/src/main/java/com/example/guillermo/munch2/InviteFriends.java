package com.example.guillermo.munch2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class InviteFriends extends AppCompatActivity {

    private android.support.v7.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_friends);


        toolbar= (android.support.v7.widget.Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
    }
}
