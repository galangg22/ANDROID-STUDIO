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

    EditText nilai;
    Spinner spinner;
    TextView tvHasil;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        load();
//        isiSpinner();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void load ()
    {
        nilai = findViewById(R.id.nilai);
        spinner = findViewById(R.id.spinner);
        tvHasil = findViewById(R.id.tvHasil);
    }

//    public void isiSpinner()
//    {
//        String[] isi = {"Celsius to Reamur", "Celcius to Fahrenheit", "Celcius to Kelvin"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
//        spinner.setAdapter(adapter);
//    }

    public void btnConvert (View view)
    {
        String pilihan = spinner.getSelectedItem().toString();
        double suhu = Double.parseDouble(nilai.getText().toString());

        if (nilai.getText().toString().equals(""))
        {
            Toast.makeText(this, "Nilai Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
        } else {
            if(pilihan.equals("Celsius to Reamur")) {
                cToR(suhu);
            } else if (pilihan.equals("Celsius to Fahrenheit")) {
                cToF(suhu);
            } else if (pilihan.equals("Celsius to Kelvin")) {
                cToK(suhu);
            } else if(pilihan.equals("Reamur to Celsius")) {
                rToC(suhu);
            } else if(pilihan.equals("Reamur to Fahrenheit")){
                rToF(suhu);
            } else if(pilihan.equals("Reamur to Kelvin")) {
                rToK(suhu);
            } else if(pilihan.equals("Fahrenheit to Celsius")) {
                fToC(suhu);
            } else if (pilihan.equals("Fahrenheit to Kelvin")) {
                fToK(suhu);
            } else if(pilihan.equals("Fahrenheit to Reamur")) {
                fToR(suhu);
            }
        }

    }

    public void cToF (double suhu)
    {
        tvHasil.setText(((9.00/5.00)*(suhu+32))+ " °F");
    }
    public void cToK (double suhu)
    {
        tvHasil.setText((suhu+273.15)+ " K");
    }
    public void cToR (double suhu)
    {
        tvHasil.setText((4.00/5.00)*suhu+ " °R");
    }
    public void fToC (double suhu)
    {
        tvHasil.setText(((suhu-32.00)*5.00/9.00)+ " °C");
    }
    public void fToK (double suhu)
    {
        tvHasil.setText(((suhu+459.67)*5.00/9.00)+ " K");
    }
    public void fToR (double suhu)
    {
        tvHasil.setText(((4.00/9.00)*(suhu-32))+ " °R");
    }
    public void rToC (double suhu)
    {
        tvHasil.setText((suhu/0.800)+ " °C");
    }
    public void rToF (double suhu)
    {
        tvHasil.setText(((suhu*2.25)+32)+ " °F");
    }
    public void rToK (double suhu)
    {
        tvHasil.setText(((suhu*0.800)+273.15)+ " K");
    }
}

