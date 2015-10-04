package com.example.guillermo.munch2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ImageView;


/**
 * Created by Guillermo on 04/10/2015.
 */
public class splash extends Activity {
    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        final ImageView iv = (ImageView) findViewById(R.id.imageView);
        finish();
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);

    }
}

