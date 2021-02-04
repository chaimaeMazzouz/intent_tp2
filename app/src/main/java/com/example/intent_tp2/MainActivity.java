package com.example.intent_tp2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Toast.makeText(getBaseContext(),"you clicked me",Toast.LENGTH_LONG).show();
        switch(v.getId()) {
            case R.id.btn1:
                Intent intent = new Intent(this, Activity2.class);
                startActivityForResult(intent,1);
                break;
            case R.id.btn2:
                Intent intent2 = new Intent(this, Activity3.class);
                intent2.putExtra("nom" , "Mazzouz");
                startActivity(intent2);
                break;
            case R.id.btn3:
                if (ContextCompat.checkSelfPermission(
                        this, Manifest.permission.CAMERA) ==
                        PackageManager.PERMISSION_DENIED) {
                    ActivityCompat.requestPermissions(this,
                            new String[] { Manifest.permission.CAMERA },3);
                }
                Intent intent3 = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivity(intent3);
                break;
            case R.id.btn4:
                Intent intent4 = new Intent("android.media.action.VIDEO_CAPTURE");
                startActivity(intent4);
                break;
            default:Toast.makeText(getBaseContext(),"yes i get executed",Toast.LENGTH_LONG).show();
        }
    }
}
