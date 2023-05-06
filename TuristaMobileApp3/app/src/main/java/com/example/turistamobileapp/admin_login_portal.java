package com.example.turistamobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class admin_login_portal extends AppCompatActivity {

    EditText admin_username,admin_password;
    Button btn_cancel,btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login_portal);

        admin_username = findViewById(R.id.edit_admin_username);
        admin_password = findViewById(R.id.edit_admin_password);
        btn_cancel = findViewById(R.id.button_admin_cancel);
        btn_submit = findViewById(R.id.button_admin_submit);

        btn_cancel.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"ADMIN CANCEL",Toast.LENGTH_LONG).show();
            startActivity(new Intent(admin_login_portal.this,MainActivity.class));
        });

        btn_submit.setOnClickListener(v -> {
            String username = admin_username.getText().toString();
            String password = admin_password.getText().toString();

            if(username.equals("admin") && (password.equals("admin123"))){
                Toast.makeText(admin_login_portal.this,"WELCOME ADMIN USER",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),admin_menu_portal.class);
                startActivity(intent);
            }else{
                Toast.makeText(admin_login_portal.this,"INVALID USERNAME AND PASSWORD",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
