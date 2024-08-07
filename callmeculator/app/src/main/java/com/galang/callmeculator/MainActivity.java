package com.galang.callmeculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView tvhasil;
    EditText bil1,bil2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        load();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void load()
    {
        tvhasil = findViewById(R.id.tvhasil);
        bil1 = findViewById(R.id.bil1);
        bil2 = findViewById(R.id.bil2);
    }

    public double[] getBil()
    {
        double[] bil = new double[2];
        if (bil1.getText().toString().equals("") || bil2.getText().toString().equals(""))
        {
            Toast.makeText(this, "ADA BILANGAN YANG KOSONG", Toast.LENGTH_SHORT).show();
            return null;
        }

        try {
            bil[0] = Double.parseDouble(bil1.getText().toString());
            bil[1] = Double.parseDouble(bil2.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "MASUKKAN BILANGAN YANG VALID", Toast.LENGTH_SHORT).show();
            return null;
        }

        return bil;
    }

    public void btnJumlah(View view)
    {
        double[] bilangan = getBil();

        if (bilangan != null) {
            double hasil = bilangan[0] + bilangan[1];
            tvhasil.setText(String.valueOf(hasil));
        }
    }

    public void btnKurang(View view)
    {
        double[] bilangan = getBil();

        if (bilangan !=null) {
            double hasil = bilangan[0]-bilangan[1];
            tvhasil.setText(String.valueOf(hasil));
        }
    }

    public void btnKali(View view)
    {
        double[] bilangan = getBil();

        if (bilangan !=null) {
            double hasil = bilangan[0]*bilangan[1];
            tvhasil.setText(String.valueOf(hasil));
        }
    }

    public void btnBagi(View view)
    {
        double[] bilangan = getBil();

        if (bilangan !=null) {
            double hasil = bilangan[0]/bilangan[1];
            tvhasil.setText(String.valueOf(hasil));
        }
    }
}