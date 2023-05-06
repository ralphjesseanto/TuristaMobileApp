package com.example.turistamobileapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class info_oneAdapter extends RecyclerView.Adapter<info_oneAdapter.info_oneVH> {

    private static List<info_one_desc> info_one_descList;
    public info_oneAdapter(List<info_one_desc> info_one_descList) {
        info_oneAdapter.info_one_descList = info_one_descList;
    }

    @NonNull
    @Override
    public info_oneAdapter.info_oneVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_tourism_info_one,parent,false);
        return new info_oneVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull info_oneAdapter.info_oneVH holder, int position) {
        info_one_desc info_one_desc = info_one_descList.get(position);
        holder.img_photo_hotel.setImageResource(info_one_desc.getImg_photo_hotel());
        holder.hotel_name.setText(info_one_desc.getName_hotel());
        holder.hotel_address.setText(info_one_desc.getHotel_address());
        holder.hotel_contact_number.setText(info_one_desc.getHotel_contact_number());
        holder.hotel_url_link.setText(info_one_desc.getHotel_url_link());
        holder.img_map_hotel.setImageResource(info_one_desc.getImg_map_hotel());
    }

    public void filterList(List<info_one_desc> filteredList){
        info_one_descList = filteredList;
    }
    @Override
    public int getItemCount() {
        return info_one_descList.size();
    }

    public static class info_oneVH extends RecyclerView.ViewHolder {
        TextView hotel_name,hotel_address,hotel_contact_number,hotel_url_link;
        ImageView img_photo_hotel,img_map_hotel;
        public info_oneVH(@NonNull View itemView) {
            super(itemView);
            img_photo_hotel =itemView.findViewById(R.id.img_photo_hotel);
            hotel_name=itemView.findViewById(R.id.hotel_name);
            hotel_address=itemView.findViewById(R.id.hotel_address);
            hotel_contact_number=itemView.findViewById(R.id.hotel_phone);
            hotel_url_link=itemView.findViewById(R.id.hotel_page);
            img_map_hotel=itemView.findViewById(R.id.img_hotel_map);
        }
    }
}
