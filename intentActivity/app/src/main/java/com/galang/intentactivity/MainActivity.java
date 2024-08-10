package com.galang.intentactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText etBarang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        load();

    }
    public void load(){
        etBarang = findViewById(R.id.etBarang);
    }

    public void btnbarang(View view) {
        String barang = etBarang.getText().toString();
        Intent intent = new Intent(this, Barang.class);
        intent.putExtra("ISI", barang);
        startActivity(intent);
    }
    public void btnpembelian(View view) {
        String beli = etBarang.getText().toString();
        Intent intent = new Intent(this, Pembelian.class);
        intent.putExtra("ISI", beli);
        startActivity(intent);
    }
    public void btnpenjualan(View view) {
        String jual = etBarang.getText().toString();
        Intent intent = new Intent(this, Penjualan.class);
        intent.putExtra("ISI", jual);
        startActivity(intent);
    }
}