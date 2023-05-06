package com.example.turistamobileapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class info_sevenAdapter  extends RecyclerView.Adapter<info_sevenAdapter.info_sevenVH>{

    List<info_seven_desc> info_seven_list;
    public info_sevenAdapter(List<info_seven_desc> info_seven_descList) {
        this.info_seven_list= info_seven_descList;
    }
    @NonNull
    @Override
    public info_sevenAdapter.info_sevenVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_tourism_info_seven,parent,false);
        return new info_sevenVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull info_sevenAdapter.info_sevenVH holder, int position) {
        info_seven_desc info_seven_desc = info_seven_list.get(position);
        holder.name.setText(info_seven_desc.getChurch_name());
        holder.address.setText(info_seven_desc.getChurch_address());
        holder.phone.setText(info_seven_desc.getChurch_phone());
        holder.page_link.setText(info_seven_desc.getChurch_page());
        holder.img_photo.setImageResource(info_seven_desc.getImg_church_photo());
        holder.img_map.setImageResource(info_seven_desc.getImg_church_map());
    }

    @Override
    public int getItemCount() {
        return info_seven_list.size();
    }

    public void filterList(List<info_seven_desc> filteredList){
        info_seven_list = filteredList;
    }

    public static class info_sevenVH extends RecyclerView.ViewHolder {
        ImageView img_photo,img_map;
        TextView name,address,phone,page_link;
        public info_sevenVH(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.church_name);
            address=itemView.findViewById(R.id.church_address);
            phone=itemView.findViewById(R.id.church_phone);
            page_link=itemView.findViewById(R.id.church_page);
            img_photo=itemView.findViewById(R.id.img_photo_church);
            img_map=itemView.findViewById(R.id.img_church_map);
        }
    }
}
