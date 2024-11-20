package com.example.menusandpickers;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button btnContextualMenu = findViewById(R.id.btnContextualMenu);
        Button btnAppBar = findViewById(R.id.btnAppBar);
        Button btnPopup = findViewById(R.id.btnPopupMenu);
        Button btnDialogs = findViewById(R.id.btnDialogs);
        Button btnPickers = findViewById(R.id.btnPickers);
    //comment only


        btnAppBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,AppBar.class);
                startActivity(intent);

            }
        });

        btnContextualMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ContextualMenu.class);
                startActivity(intent);
            }
        });

        btnPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ContextualMenu.class);
                startActivity(intent);
            }
        });

        btnDialogs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Dialogs.class);
                startActivity(intent);
            }
        });

        btnPickers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Pickers.class);
                startActivity(intent);
            }
        });

    }
}