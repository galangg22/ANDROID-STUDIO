package com.galang.recycleview;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.galang.recycleview.R;
import com.galang.recycleview.Siswa;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    com.galang.recycleview.SiswaAdapter adapter;
    List<com.galang.recycleview.Siswa> siswaList;

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
        isiData();
    }

    public void load(){
        recyclerView = findViewById(R.id.rcvSiswa);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public  void isiData(){
        siswaList = new ArrayList<com.galang.recycleview.Siswa>();
        siswaList.add(new com.galang.recycleview.Siswa("Namjoon","Ilsan"));
        siswaList.add(new com.galang.recycleview.Siswa("Seokjin","Anyang"));
        siswaList.add(new com.galang.recycleview.Siswa("Yoongi","Bukgu"));
        siswaList.add(new com.galang.recycleview.Siswa("Hoseok","Gwangju"));
        siswaList.add(new com.galang.recycleview.Siswa("Jimin","Busan"));
        siswaList.add(new com.galang.recycleview.Siswa("Taehyung","Daegu"));
        siswaList.add(new com.galang.recycleview.Siswa("Jungkook","Seoul"));

        adapter = new com.galang.recycleview.SiswaAdapter(this,siswaList);
        recyclerView.setAdapter(adapter);
    }

    public void btnTambah(View view) {
        siswaList.add(new Siswa("Soohyun","Seoul"));
        adapter.notifyDataSetChanged();
    }
}