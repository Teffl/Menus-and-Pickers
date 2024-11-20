package com.example.menusandpickers;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Dialogs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.dialogs);

        Button dButton = findViewById(R.id.dialog_button);
        dButton.setOnClickListener(this::onClickShowAlert);
    }

    public void onClickShowAlert(View v) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Dialogs.this);
        alertDialog.setTitle("WARNING ⚠️⚠️⚠️");
        alertDialog.setMessage(R.string.dMessage);

        // Positive button
        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        // Negative button
        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        // Neutral button
        alertDialog.setNeutralButton("Later", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.show();
    }
}

