package com.zxc.dobbytest;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @SuppressLint("UnsafeDynamicallyLoadedCode")
    public void ssss(View view) {
//        String ss = this.getApplicationInfo().nativeLibraryDir;
//        System.loadLibrary("hookdobbytest");
        File file = new File("/data/local/tmp/libhookdobbytest.so");
        System.out.println("file.exists():" + file.exists());
        Runtime.getRuntime().load("/data/local/tmp/libhookdobbytest.so");
        Toast.makeText(this, "6666666666", Toast.LENGTH_SHORT).show();
        System.out.println(Build.MODEL);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            System.out.println(Build.getFingerprintedPartitions());
        }
        System.out.println(Build.BOARD);
    }

}