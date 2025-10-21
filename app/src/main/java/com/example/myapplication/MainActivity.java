package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button listViewBtn = findViewById(R.id.btn_listview);
        Button alertDialogBtn = findViewById(R.id.btn_alert_dialog);
        Button menuBtn = findViewById(R.id.btn_menu);

        listViewBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
            startActivity(intent);
        });

        alertDialogBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AlertDialogActivity.class);
            startActivity(intent);
        });

        menuBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MenuActivity.class);
            startActivity(intent);
        });

        Button actionModeBtn = findViewById(R.id.btn_action_mode);
        actionModeBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ActionModeActivity.class);
            startActivity(intent);
        });
    }
}