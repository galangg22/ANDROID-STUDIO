package com.galang.intentactivity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Barang extends AppCompatActivity {


    TextView tvBarang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_barang);

        load();
        ambildata();
    }
    public void load(){
        tvBarang = findViewById(R.id.tvBarang);
    }

    public void ambildata(){
        String ambil = getIntent().getStringExtra("ISI");
        tvBarang.setText(ambil);
    }

}