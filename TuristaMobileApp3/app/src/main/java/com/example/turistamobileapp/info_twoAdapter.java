package com.example.turistamobileapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class info_twoAdapter extends RecyclerView.Adapter<info_twoAdapter.info_twoVH>{

    List<info_two_desc> info_two_descList;
    public info_twoAdapter(List<info_two_desc> info_two_descList) {
        this.info_two_descList = info_two_descList;
    }
    @NonNull
    @Override
    public info_twoAdapter.info_twoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_tourism_info_two,parent,false);
        return new info_twoVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull info_twoAdapter.info_twoVH holder, int position) {
        info_two_desc info_two_desc = info_two_descList.get(position);
        holder.name.setText(info_two_desc.getResort_name());
        holder.address.setText(info_two_desc.getResort_address());
        holder.contact_number.setText(info_two_desc.getResort_phone());
        holder.page_link.setText(info_two_desc.getResort_page());
        holder.img_photo.setImageResource(info_two_desc.getImg_resort_photo());
        holder.img_map.setImageResource(info_two_desc.getImg_resort_map());
    }

    @Override
    public int getItemCount() {
        return info_two_descList.size();
    }

    public void filterList(List<info_two_desc> filteredList){
        info_two_descList = filteredList;
    }

    public static class info_twoVH extends RecyclerView.ViewHolder {
        TextView name,address,contact_number,page_link;
        ImageView img_photo,img_map;
        public info_twoVH(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.resorts_name);
            address=itemView.findViewById(R.id.resorts_address);
            contact_number=itemView.findViewById(R.id.resorts_phone);
            page_link=itemView.findViewById(R.id.resorts_page);
            img_photo=itemView.findViewById(R.id.img_photo_beach_resorts);
            img_map=itemView.findViewById(R.id.img_resorts_map);
        }
    }
}
