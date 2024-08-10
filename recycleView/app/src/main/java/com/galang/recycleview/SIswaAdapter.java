package com.galang.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SiswaAdapter extends RecyclerView.Adapter<SiswaAdapter.ViewHolder> {

    private Context context;
    private List<Siswa> siswaList;

    //menerima kontek dan array siswa, (setiap index berisi objek dari Siswa.java)
    public SiswaAdapter(Context context, List<Siswa> siswaList) {
        this.context = context;
        this.siswaList = siswaList;
    }


    // // Membuat ViewHolder baru dan meng-inflate layout item_siswa
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_siswa, viewGroup, false);

        return new ViewHolder(v);
    }

    // Mengikat data siswa ke ViewHolder
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        final Siswa siswa = siswaList.get(i);
        viewHolder.tvNama.setText(siswa.getNama());
        viewHolder.tvAlamat.setText(siswa.getAlamat());

//        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, "Nama : " +siswa.getNama() + " Alamat : "+siswa.getAlamat(), Toast.LENGTH_SHORT).show();
//            }
//        });

        viewHolder.tvMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(context, viewHolder.tvMenu);
                popupMenu.inflate(R.menu.menu_opt);

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        int menuItemId = menuItem.getItemId();

                        if (menuItemId == R.id.menu_simpan) {
                            Toast.makeText(context, "Simpan data "+ siswa.getNama(), Toast.LENGTH_SHORT).show();
                        } else if (menuItemId == R.id.menu_hapus) {
                            siswaList.remove(i);
                            notifyDataSetChanged();
                            Toast.makeText(context, siswa.getNama()+ " sudah dihapus", Toast.LENGTH_SHORT).show();
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return siswaList.size();
    }

    // ViewHolder untuk memegang referensi ke tampilan item_siswa
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvNama, tvAlamat, tvMenu;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);

            tvNama = itemView.findViewById(R.id.tvNama);
            tvAlamat = itemView.findViewById(R.id.tvAlamat);
            tvMenu = itemView.findViewById(R.id.tvMenu);

        }
    }
}

