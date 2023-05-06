package com.example.turistamobileapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class info_eightAdapter extends RecyclerView.Adapter<info_eightAdapter.info_eightVH>{

    List<info_eight_desc> info_eight_descList;
    public info_eightAdapter(List<info_eight_desc> info_eight_descList) {
        this.info_eight_descList = info_eight_descList;
    }
    @NonNull
    @Override
    public info_eightAdapter.info_eightVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_tourism_info_eight,parent,false);
        return new info_eightVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull info_eightAdapter.info_eightVH holder, int position) {
        info_eight_desc info_eight_desc = info_eight_descList.get(position);
        holder.bank_name.setText(info_eight_desc.getName_bank());
        holder.bank_address.setText(info_eight_desc.getBank_address());
        holder.bank_contact_number.setText(info_eight_desc.getBank_contact_number());
        holder.bank_page.setText(info_eight_desc.getBank_page());
        holder.photo_bank.setImageResource(info_eight_desc.getPhoto_bank());
        holder.img_bank_map.setImageResource(info_eight_desc.getImg_bank_map());
    }

    @Override
    public int getItemCount() {
        return info_eight_descList.size();
    }

    public void filterList(List<info_eight_desc> filteredList){
        info_eight_descList = filteredList;
    }

    public static class info_eightVH extends RecyclerView.ViewHolder {
        TextView bank_name,bank_address,bank_contact_number,bank_page;
        ImageView photo_bank,img_bank_map;
        public info_eightVH(@NonNull View itemView) {
            super(itemView);
            bank_name=itemView.findViewById(R.id.bank_name);
            bank_address = itemView.findViewById(R.id.bank_address);
            bank_contact_number = itemView.findViewById(R.id.bank_contact_number);
            bank_page = itemView.findViewById(R.id.bank_page);
            photo_bank = itemView.findViewById(R.id.img_photo_bank);
            img_bank_map = itemView.findViewById(R.id.imgVw_bank_map);
        }
    }
}
