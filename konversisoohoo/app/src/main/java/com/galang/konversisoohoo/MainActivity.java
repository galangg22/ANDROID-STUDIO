package com.galang.konversisoohoo;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    EditText nilai;
    TextView tvHasil;

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

        load();

    }

    public void load() {
        spinner = findViewById(R.id.spinner);
        nilai = findViewById(R.id.nilai);
        tvHasil = findViewById(R.id.tvHasil);
    }
//    public void isiSpinner() {
//        String[] isi = {"celcius to reamur", "celcius to farenheit", "celcius to kelvin"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,isi);
//        spinner.setAdapter(adapter);
//    }

    public void btnConvert(View view) {
        String pilihan = spinner.getSelectedItem().toString();

        if (nilai.getText().toString().equals("")) {
            Toast.makeText(this, "nilai tidak boleh kosong bolo", Toast.LENGTH_SHORT).show();
        }else {
    if (pilihan.equals("celcius to reamur")){
        ctr();
    }
    if (pilihan.equals("celcius to farenheit")){
        ctf();
    }

        }

    }
    public void ctr() {
        double suhu = Double.parseDouble(nilai.getText().toString());
        double hasil = (4.0/5.0) * suhu;

        tvHasil.setText(hasil +"");
    }
    public void ctf(){
        Toast.makeText(this, "belum dibuat", Toast.LENGTH_SHORT).show();
    }
}