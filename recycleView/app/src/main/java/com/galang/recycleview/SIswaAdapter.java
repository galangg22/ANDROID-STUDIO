package com.galang.recycleview;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.galang.recycleview.R;

import java.util.List;


public class SiswaAdapter extends RecyclerView.Adapter<SiswaAdapter.ViewHolder> {

    private Context context;
    private List<com.galang.recycleview.Siswa> siswaList;

    public SiswaAdapter(Context context, List<com.galang.recycleview.Siswa> siswaList) {
        this.context = context;
        this.siswaList = siswaList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_siswa,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        com.galang.recycleview.Siswa siswa = siswaList.get(position);
        holder.tvNama.setText(siswa.getNama());
        holder.tvAlamat.setText(siswa.getAlamat());

        /*
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Nama: "+siswa.getNama() + "Alamat:"+siswa.getAlamat(), Toast.LENGTH_SHORT).show();
            }
        });
         */

        holder.tvMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(context,holder.tvMenu);
                popupMenu.inflate(R.menu.menu_opt);

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        int itemId = menuItem.getItemId();
                        if (itemId == R.id.menu_simpan) {
                            Toast.makeText(context, "Simpan Data"+siswa.getNama(), Toast.LENGTH_SHORT).show();
                        }else  if (itemId == R.id.menu_hapus){
                            siswaList.remove(holder.getAdapterPosition());
                            notifyDataSetChanged();
                            Toast.makeText(context, siswa.getNama()+"Sudah Dihapus", Toast.LENGTH_SHORT).show();
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

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvNama,tvAlamat,tvMenu;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNama = itemView.findViewById(R.id.tvNama);
            tvAlamat = itemView.findViewById(R.id.tvAlamat);
            tvMenu = itemView.findViewById(R.id.tvMenu);
        }
    }

}
