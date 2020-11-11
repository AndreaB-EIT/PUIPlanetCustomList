package com.example.puiplanetcustomlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.puiplanetcustomlist.task.APIPlanetDownload;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        APIPlanetDownload downloadTask = new APIPlanetDownload(this);
        Thread downloadThread = new Thread(downloadTask);
        downloadThread.start();
    }
}