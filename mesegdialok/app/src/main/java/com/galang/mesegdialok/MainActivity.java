package com.galang.mesegdialok;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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
    public void showToast(String pesan) {
        Toast.makeText(this,pesan, Toast.LENGTH_SHORT).show();
    }

    public void showAlert(String pesan) {
        AlertDialog.Builder buatAlert = new AlertDialog.Builder(this);
        buatAlert.setTitle("BAHAYAAA LARII!");
        buatAlert.setMessage(pesan);

        buatAlert.show();
    }

    public void showAlertButton(String pesan) {
        AlertDialog.Builder showAlert = new AlertDialog.Builder(this);
        showAlert.setTitle("AWASSS PERINGATANN!!");
        showAlert.setMessage(pesan);

        showAlert.setPositiveButton("YEAHH", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                showToast("DATA SUDAH DIHAPUS SAMA BOS E");
            }
        });

        showAlert.setNegativeButton("GAK MAW", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                showToast("DATA MASIH ADA BOLOO");
            }
        });

        showAlert.show();

    }

    public void btnToast(View view) {
        showToast("belajar dari kesalahan");
    }

    public void btnAlerDial(View view) {
        showAlert("tp boong, hahahaha COK!!");
    }

    public void btnADB(View view) {
        showAlertButton("YAKIN INGIN MENGHAPUSNYA? PENTING LOH");
    }
}