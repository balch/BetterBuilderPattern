package com.balch.builderpattern;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User user = new User.Builder("Justin", "Ohmpa")
                .state("CA")
                .country("USA")
                .build();

        Log.d("", user.getState());
        Log.d("", user.getCountry());
    }
}
