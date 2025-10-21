package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    private TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        tvTest = findViewById(R.id.tv_test);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId(); // 获取菜单id

        if (itemId == R.id.item_font_small) {
            tvTest.setTextSize(10);
            return true;
        } else if (itemId == R.id.item_font_medium) {
            tvTest.setTextSize(16);
            return true;
        } else if (itemId == R.id.item_font_large) {
            tvTest.setTextSize(20);
            return true;
        } else if (itemId == R.id.item_common) {
            Toast.makeText(this, "点击了普通菜单项", Toast.LENGTH_SHORT).show();
            return true;
        } else if (itemId == R.id.item_color_red) {
            tvTest.setTextColor(Color.RED);
            return true;
        } else if (itemId == R.id.item_color_black) {
            tvTest.setTextColor(Color.BLACK);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
