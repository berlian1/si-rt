package com.example.berlian.si_rt;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by berlian on 6/16/2017.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private static final String TAG = "CustomAdapter";

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView,pass,name;

        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            name =(TextView)v.findViewById(R.id.nama);
            pass = (TextView)v.findViewById(R.id.tanggal);
        }

        public TextView getTextView() {
            return textView;
        }
    }
    private List<response> list;
    public Adapter(List<response> list){
        this.list = list;


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_row, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(list.get(position).getAdminNama());
        holder.pass.setText(list.get(position).getAdminPasswd());
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }


}
