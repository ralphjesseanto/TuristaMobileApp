package com.example.turistamobileapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class info_elevenAdapter extends RecyclerView.Adapter<info_elevenAdapter.info_elevenVH>{

    List<info_eleven_desc> info_eleven_descList;

    public info_elevenAdapter(List<info_eleven_desc> info_eleven_descList) {
        this.info_eleven_descList = info_eleven_descList;
    }

    @NonNull
    @Override
    public info_elevenAdapter.info_elevenVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_tourism_info_eleven,parent,false);
        return new info_elevenVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull info_elevenAdapter.info_elevenVH holder, int position) {
        info_eleven_desc info_eleven_desc = info_eleven_descList.get(position);
        holder.tourism_hub_name.setText(info_eleven_desc.getTourism_hub_name());
        holder.addresstxt.setText(info_eleven_desc.getAddress());
        holder.contact_number.setText(info_eleven_desc.getContact_number());
        holder.page.setText(info_eleven_desc.getPage());
    }

    @Override
    public int getItemCount() {
        return info_eleven_descList.size();
    }

    public static class info_elevenVH extends RecyclerView.ViewHolder {
        TextView tourism_hub_name,addresstxt,contact_number,page;
        public info_elevenVH(@NonNull View itemView) {
            super(itemView);
            tourism_hub_name=itemView.findViewById(R.id.tourism_hub_name);
            addresstxt=itemView.findViewById(R.id.tourism_address);
            contact_number=itemView.findViewById(R.id.tourism_phone);
            page=itemView.findViewById(R.id.tourism_page);
        }
    }
}
