package com.example.turistamobileapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class info_nineAdapter extends RecyclerView.Adapter<info_nineAdapter.info_nineVH>{

    List<info_nine_desc> info_nine_descList;

    public info_nineAdapter(List<info_nine_desc> info_nine_descList) {
        this.info_nine_descList = info_nine_descList;
    }
    @NonNull
    @Override
    public info_nineAdapter.info_nineVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_tourism_info_nine,parent,false);
        return new info_nineVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull info_nineAdapter.info_nineVH holder, int position) {
        info_nine_desc info_nine_desc = info_nine_descList.get(position);
        holder.port_name.setText(info_nine_desc.getPort_name());
        holder.port_address.setText(info_nine_desc.getPort_address());
        holder.port_phone.setText(info_nine_desc.getPort_phone());
        holder.img_port.setImageResource(info_nine_desc.getImg_port());
        holder.img_port_map.setImageResource(info_nine_desc.getImg_map());
    }

    @Override
    public int getItemCount() {
        return info_nine_descList.size();
    }

    public void filterList(List<info_nine_desc> filteredList){
        info_nine_descList = filteredList;
    }

    public static class info_nineVH extends RecyclerView.ViewHolder {

        TextView port_name,port_address,port_phone;
        ImageView img_port,img_port_map;
        public info_nineVH(@NonNull View itemView) {
            super(itemView);
            port_name=itemView.findViewById(R.id.port_name);
            port_address=itemView.findViewById(R.id.port_address);
            port_phone=itemView.findViewById(R.id.port_contact_number);
            img_port=itemView.findViewById(R.id.img_photo_port);
            img_port_map=itemView.findViewById(R.id.img_navigation_map);
        }
    }
}
