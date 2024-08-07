package com.galang.sqlitedatabase;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText etBarang, etStok, etHarga;
    TextView tvPilihan;
    Database db;
    List<Barang> databarang = new ArrayList<>();
    BarangAdapter adapter;
    RecyclerView rcvBarang;
    String idbarang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        load();
        selectData();
    }

    public void load() {
        db = new Database(this);
        db.buatTabel();

        etBarang = findViewById(R.id.etBarang);
        etStok = findViewById(R.id.etStok);
        etHarga = findViewById(R.id.etHarga);
        tvPilihan = findViewById(R.id.tvPilihan);
        rcvBarang = findViewById(R.id.rcvBarang);

        rcvBarang.setLayoutManager(new LinearLayoutManager(this));
        rcvBarang.setHasFixedSize(true);

        // Set default value of tvPilihan to INSERT
        tvPilihan.setText("INSERT");
    }

    public void simpan(View view) {
        String barang = etBarang.getText().toString();
        String stok = etStok.getText().toString();
        String harga = etHarga.getText().toString();
        String pilihan = tvPilihan.getText().toString();

        if (barang.isEmpty() || stok.isEmpty() || harga.isEmpty()) {
            pesan("Data anda kosong");
        } else {
            if (pilihan.equals("INSERT")) {
                pesan("INSERT");

                String sql = "INSERT INTO tblbarang (barang, stok, harga) VALUES('" + barang + "', " + stok + ", " + harga + ")";
                pesan(sql);
                db.runSQL(sql);
            } else {
                pesan("UPDATE");
                String sql = "UPDATE tblbarang SET barang='" + barang + "', stok=" + stok + ", harga=" + harga + " WHERE idbarang=" + idbarang + ";";
                if (db.runSQL(sql))
                {
                    pesan("Data berhasil diubah");

                    selectData();
                } else {
                    pesan("Data tidak bisa diubah");
                }
            }
        }

        etBarang.setText("");
        etStok.setText("");
        etHarga.setText("");
        tvPilihan.setText("INSERT");

        // Refresh data
        selectData();
    }

    public void pesan(String isi) {
        Toast.makeText(this, isi, Toast.LENGTH_SHORT).show();
    }

    public void selectData() {
        String sql = "SELECT * FROM tblbarang ORDER BY barang ASC";
        Cursor cursor = db.select(sql);

        databarang.clear();
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                String idbarang = cursor.getString(cursor.getColumnIndex("idbarang"));
                String barang = cursor.getString(cursor.getColumnIndex("barang"));
                String stok = cursor.getString(cursor.getColumnIndex("stok"));
                String harga = cursor.getString(cursor.getColumnIndex("harga"));

                databarang.add(new Barang(idbarang, barang, stok, harga));
            }

            adapter = new BarangAdapter(this, databarang);
            rcvBarang.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        } else {
            pesan("Data Kosong");
        }
        cursor.close();
    }

    public void deleteData(String id)
    {
        idbarang = id;
        String sql = "DELETE FROM tblbarang WHERE idbarang="+idbarang+";";

        AlertDialog.Builder al = new AlertDialog.Builder(this);
        al.setTitle("PERINGATAN !");
        al.setMessage("Apakah anda yakin untuk menghapus data ?");
        al.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(db.runSQL(sql))
                {
                    pesan("Data sudah dihapus");
                    selectData();
                } else {
                    pesan("Data tidak bisa dihapus");
                }
            }
        });
        al.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        al.show();


    }

    public void selectUpdate(String id)
    {
        idbarang = id;
        String sql = "SELECT * FROM tblbarang WHERE idbarang="+idbarang+";";

        Cursor cursor = db.select(sql);
        cursor.moveToNext();

        etBarang.setText(cursor.getString(cursor.getColumnIndex("barang")));
        etHarga.setText(cursor.getString(cursor.getColumnIndex("harga")));
        etStok.setText(cursor.getString(cursor.getColumnIndex("stok")));

        tvPilihan.setText("UPDATE");
    }
}
