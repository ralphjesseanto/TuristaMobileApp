package com.example.turistamobileapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class info_sixAdapter extends RecyclerView.Adapter<info_sixAdapter.info_sixAdapterVH>{

    List<info_six_desc> info_six_descList;
    public info_sixAdapter(List<info_six_desc> info_six_descList){
        this.info_six_descList = info_six_descList;
    }

    @NonNull
    @Override
    public info_sixAdapter.info_sixAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_tourism_info_six,parent,false);
        return new info_sixAdapterVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull info_sixAdapter.info_sixAdapterVH holder, int position) {
        info_six_desc info_six_desc = info_six_descList.get(position);
        holder.mall_name.setText(info_six_desc.getMall_name());
        holder.mall_address.setText(info_six_desc.getMall_address());
        holder.mall_phone.setText(info_six_desc.getMall_phone());
        holder.mall_page.setText(info_six_desc.getMall_page());
        holder.img_mall.setImageResource(info_six_desc.getImg_mall());
        holder.img_map.setImageResource(info_six_desc.getImg_map());
    }

    @Override
    public int getItemCount() {
        return info_six_descList.size();
    }
    public void filterList(List<info_six_desc> filteredList){

       info_six_descList = filteredList;
    }

    public static class info_sixAdapterVH extends RecyclerView.ViewHolder {
        ImageView img_mall,img_map;
        TextView mall_name,mall_address,mall_phone,mall_page;
        public info_sixAdapterVH(@NonNull View itemView) {
            super(itemView);
            mall_name=itemView.findViewById(R.id.mall_name);
            mall_address=itemView.findViewById(R.id.mall_address);
            mall_phone=itemView.findViewById(R.id.mall_phone);
            mall_page=itemView.findViewById(R.id.mall_page);
            img_mall=itemView.findViewById(R.id.img_photo_mall);
            img_map=itemView.findViewById(R.id.img_navigation_map);
        }
    }
}
