package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class AlertDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);

        Button showDialogBtn = findViewById(R.id.btn_show_dialog);
        showDialogBtn.setOnClickListener(v -> {
            View customView = LayoutInflater.from(this).inflate(R.layout.dialog_custom, null);

            EditText usernameEt = customView.findViewById(R.id.et_username);
            EditText passwordEt = customView.findViewById(R.id.et_password);
            Button cancelBtn = customView.findViewById(R.id.btn_cancel);
            Button signInBtn = customView.findViewById(R.id.btn_sign_in);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(customView);

            AlertDialog dialog = builder.create();

            cancelBtn.setOnClickListener(v1 -> dialog.dismiss());

            signInBtn.setOnClickListener(v1 -> {
                String username = usernameEt.getText().toString();
                String password = passwordEt.getText().toString();
                Toast.makeText(AlertDialogActivity.this, "用户名：" + username + "，密码：" + password, Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            });

            dialog.show();
        });
    }
}
