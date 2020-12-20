package com.example.myapplication.ui.Exit;

import androidx.appcompat.app.AppCompatActivity;

public class Exit {

    public Exit(AppCompatActivity MainActivity) {
        MainActivity.finish();
        System.exit(0);
    }
}
