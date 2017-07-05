package com.example.berlian.si_rt.kegiatan;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.berlian.si_rt.R;

import java.util.List;

/**
 * Created by berlian on 6/16/2017.
 */

public class AdapterKegiatan extends RecyclerView.Adapter<AdapterKegiatan.ViewHolder> {
    private static final String TAG = "CustomAdapter";
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView,kategori,nama,subKat,judul,tanggal,teks;
        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            nama =(TextView)v.findViewById(R.id.nama);
            kategori = (TextView)v.findViewById(R.id.kategori);
            subKat = (TextView)v.findViewById(R.id.subKat);
            judul = (TextView)v.findViewById(R.id.judul);
            tanggal = (TextView)v.findViewById(R.id.tanggal);
            teks = (TextView)v.findViewById(R.id.teks);
        }
        public TextView getTextView() {
            return textView;
        }
    }
    private List<resKegiatan> list;
    public AdapterKegiatan(List<resKegiatan> list){
        this.list = list;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_row, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;}
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tanggal.setText(list.get(position).getTanggal());
        holder.judul.setText(list.get(position).getJudul());
        holder.nama.setText(list.get(position).getNama());
        holder.kategori.setText(list.get(position).getKategori());
        holder.subKat.setText(list.get(position).getSubkategori());
        holder.teks.setText(list.get(position).getTeks());}
    @Override
    public int getItemCount() {
        return this.list.size();
    }
}
