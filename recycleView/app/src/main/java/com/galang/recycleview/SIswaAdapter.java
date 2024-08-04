package com.galang.recycleview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SIswaAdapter extends RecyclerView.Adapter<SIswaAdapter.ViewHolder> {

    private Context context;
    private List<siswa> siswaList;

    public SIswaAdapter(Context context, List<siswa> siswaList) {
        this.context = context;
        this.siswaList = siswaList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    siswa siswa = siswaList.size();
    ViewHolder.tvNama.setText(siswa.getNama());
    ViewHolder.tvAlamat.setText(siswa.getAlamat());

//    ViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            Toast.makeText("nama : " +siswa.getNama()+ "Alamat : " +siswa.getAlamat(), Toast.LENGTH_SHORT).show();
//        }
//    });
//    }

    @Override
    public int getItemCount() {
        return siswaList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvNama, tvAlamat, tvMenu;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNama = itemView.findViewById(R.id.tvNama);
            tvAlamat = itemView.findViewById(R.id.tvAlamat);
            tvMenu = itemView.findViewById(R.id.tvMenu);
        }
    }
}
