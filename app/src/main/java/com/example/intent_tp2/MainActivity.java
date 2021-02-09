package com.example.intent_tp2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final int REQUEST_IMAGE_CODE = 3;
    private static final int REQUEST_VIDEO_CODE = 6;
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
                        PackageManager.PERMISSION_GRANTED) {
                    Intent intent3 = new Intent("android.media.action.IMAGE_CAPTURE");
                    startActivity(intent3);

                }
                else{
                    ActivityCompat.requestPermissions(this,
                            new String[] { Manifest.permission.CAMERA },REQUEST_IMAGE_CODE);
                }

                break;
            case R.id.btn4:
                if (ContextCompat.checkSelfPermission(
                        this, Manifest.permission.CAMERA) ==
                        PackageManager.PERMISSION_GRANTED) {
                    Intent intent4 = new Intent("android.media.action.VIDEO_CAPTURE");
                    startActivity(intent4);

                }
                else{
                    ActivityCompat.requestPermissions(this,
                            new String[] { Manifest.permission.CAMERA },REQUEST_VIDEO_CODE);
                }
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case REQUEST_IMAGE_CODE:
                if (grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Intent intent3 = new Intent("android.media.action.IMAGE_CAPTURE");
                    startActivity(intent3);
                }
                else
                 {

                  }
                return;
            case REQUEST_VIDEO_CODE:
                if (grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Intent intent4 = new Intent("android.media.action.VIDEO_CAPTURE");
                    startActivity(intent4);
                }
                else
                {

                }
                return;


        }
    }
}
