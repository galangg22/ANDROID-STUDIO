package com.galang.intentactivity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Pembelian extends AppCompatActivity {


    TextView tvPembelian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pembelian);

        load();
        ambildata();
    }
    public void load(){
        tvPembelian = findViewById(R.id.tvPembelian);
    }

    public void ambildata(){
        String ambil = getIntent().getStringExtra("ISI");
        tvPembelian.setText(ambil);
    }

}