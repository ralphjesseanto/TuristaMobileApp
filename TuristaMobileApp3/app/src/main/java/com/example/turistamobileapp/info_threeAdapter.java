package com.example.turistamobileapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class info_threeAdapter extends RecyclerView.Adapter<info_threeAdapter.info_threeVH>{

    List<info_three_desc> info_three_descList;

    public info_threeAdapter(List<info_three_desc> info_three_descList) {
        this.info_three_descList = info_three_descList;
    }

    @NonNull
    @Override
    public info_threeAdapter.info_threeVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_tourism_info_three,parent,false);
        return new info_threeVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull info_threeAdapter.info_threeVH holder, int position) {
        info_three_desc info_three_desc = info_three_descList.get(position);
        holder.resto_name.setText(info_three_desc.getResto_name());
        holder.resto_address.setText(info_three_desc.getResto_address());
        holder.resto_contact_number.setText(info_three_desc.getResto_contact_number());
        holder.resto_page_link.setText(info_three_desc.getResto_page_link());
        holder.img_photo_resto.setImageResource(info_three_desc.getImg_resto());
        holder.img_map_resto.setImageResource(info_three_desc.getImg_map_resto());

    }

    @Override
    public int getItemCount() {
        return info_three_descList.size();
    }

    public void filterList(List<info_three_desc> filteredList){
        info_three_descList = filteredList;
    }

    public static class info_threeVH extends RecyclerView.ViewHolder {
        TextView resto_name,resto_address,resto_contact_number,resto_page_link;
        ImageView img_photo_resto,img_map_resto;

        public info_threeVH(@NonNull View itemView) {
            super(itemView);
            resto_name = itemView.findViewById(R.id.resto_name);
            resto_address = itemView.findViewById(R.id.resto_address);
            resto_contact_number = itemView.findViewById(R.id.resto_contact_number);
            resto_page_link = itemView.findViewById(R.id.resto_page);
            img_photo_resto = itemView.findViewById(R.id.img_photo_resto);
            img_map_resto = itemView.findViewById(R.id.img_resto_map);
        }
    }
}
