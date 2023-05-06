package com.example.turistamobileapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class info_fiveAdapter extends RecyclerView.Adapter<info_fiveAdapter.infoAdapterVH>{

    List<info_five_desc> info_five_descList;
    public info_fiveAdapter(List<info_five_desc> info_five_descList){
        this.info_five_descList = info_five_descList;
    }

    @NonNull
    @Override
    public info_fiveAdapter.infoAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_tourism_info_five,parent,false);
        return new infoAdapterVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull info_fiveAdapter.infoAdapterVH holder, int position) {
        info_five_desc info_five_desc = info_five_descList.get(position);
        holder.hospital_name.setText(info_five_desc.getHospital_name());
        holder.hospital_address.setText(info_five_desc.getHospital_address());
        holder.hospital_phone.setText(info_five_desc.getHospital_contact_number());
        holder.hospital_page.setText(info_five_desc.getHospital_page());
        holder.img_hospital_photo.setImageResource(info_five_desc.getImg_hospital_photo());
        holder.img_hospital_map.setImageResource(info_five_desc.getImg_hospital_map());
    }

    @Override
    public int getItemCount() {
        return info_five_descList.size();
    }

    public void filterList(List<info_five_desc> filteredList){
        info_five_descList = filteredList;
    }

    public static class infoAdapterVH extends RecyclerView.ViewHolder {
        TextView hospital_name,hospital_address,hospital_phone,hospital_page;
        ImageView img_hospital_photo,img_hospital_map;
        public infoAdapterVH(@NonNull View itemView) {
            super(itemView);
            hospital_name=itemView.findViewById(R.id.hospital_name);
            hospital_address=itemView.findViewById(R.id.hospital_address);
            hospital_phone=itemView.findViewById(R.id.hospital_contact_number);
            hospital_page=itemView.findViewById(R.id.hospital_page);
            img_hospital_photo=itemView.findViewById(R.id.img_photo_hospital);
            img_hospital_map=itemView.findViewById(R.id.img_navigation_map);
        }
    }
}
