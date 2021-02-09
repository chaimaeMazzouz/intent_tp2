package com.example.intent_tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {

    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        t1 =findViewById(R.id.t1);
        Intent i =getIntent();
        String name = i.getStringExtra("nom");
        t1.setText(name);
    }
}
