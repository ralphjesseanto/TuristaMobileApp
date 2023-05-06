package com.example.turistamobileapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class info_fourAdapter extends RecyclerView.Adapter<info_fourAdapter.info_fourVH>{

    List<info_four_desc> info_four_descList;

    public info_fourAdapter(List<info_four_desc> info_four_descList) {
        this.info_four_descList = info_four_descList;
    }

    @NonNull
    @Override
    public info_fourAdapter.info_fourVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_tourism_info_four,parent,false);
        return new info_fourVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull info_fourAdapter.info_fourVH holder, int position) {
        info_four_desc info_four_desc = info_four_descList.get(position);
        holder.img_school_photo.setImageResource(info_four_desc.getImg_school_photo());
        holder.school_name.setText(info_four_desc.getSchool_name());
        holder.school_address.setText(info_four_desc.getSchool_address());
        holder.school_contact_number.setText(info_four_desc.getSchool_contact_number());
        holder.school_page_link_one.setText(info_four_desc.getSchool_page_link_one());
        holder.school_page_link_two.setText(info_four_desc.getSchool_page_link_two());
        holder.img_school_map.setImageResource(info_four_desc.getImg_school_map());
    }

    @Override
    public int getItemCount() {
        return info_four_descList.size();
    }

    public void filterList(List<info_four_desc> filteredList){
        info_four_descList = filteredList;
    }
    public static class info_fourVH extends RecyclerView.ViewHolder {
        TextView school_name,school_address,school_contact_number,school_page_link_one,school_page_link_two;
        ImageView img_school_photo,img_school_map;
        public info_fourVH(@NonNull View itemView) {
            super(itemView);
            school_name = itemView.findViewById(R.id.school_name);
            school_address = itemView.findViewById(R.id.school_address);
            school_contact_number = itemView.findViewById(R.id.school_contact_number);
            school_page_link_one = itemView.findViewById(R.id.school_url_link_one);
            school_page_link_two = itemView.findViewById(R.id.school_url_link_two);
            img_school_photo = itemView.findViewById(R.id.img_photo_school);
            img_school_map = itemView.findViewById(R.id.img_navigation_map);
        }
    }
}
