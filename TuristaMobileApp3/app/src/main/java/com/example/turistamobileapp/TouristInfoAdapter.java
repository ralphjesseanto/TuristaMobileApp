package com.example.turistamobileapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TouristInfoAdapter extends RecyclerView.Adapter<TouristInfoAdapter.TouristInfoVH>{

    List<TouristRegisteredArrayModel> touristRegisteredArrayModels;

    public TouristInfoAdapter(List<TouristRegisteredArrayModel> touristRegisteredArrayModels) {
        this.touristRegisteredArrayModels = touristRegisteredArrayModels;
    }

    @NonNull
    @Override
    public TouristInfoAdapter.TouristInfoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_info_tourist_portal,parent,false);
        return new TouristInfoVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TouristInfoAdapter.TouristInfoVH holder, int position) {
        TouristRegisteredArrayModel touristRegisteredArrayModel = touristRegisteredArrayModels.get(position);
        holder.firstname.setText(touristRegisteredArrayModel.getFirstname());
        holder.lastname.setText(touristRegisteredArrayModel.getLastname());
        holder.address.setText(touristRegisteredArrayModel.getAddress());
        holder.place_of_origin.setText(touristRegisteredArrayModel.getPlace_of_origin());
        holder.age.setText(touristRegisteredArrayModel.getAge());
        holder.gender.setText(touristRegisteredArrayModel.getGender());
        holder.username.setText(touristRegisteredArrayModel.getUsername());
        holder.password.setText(touristRegisteredArrayModel.getPassword());
        holder.confirm_password.setText(touristRegisteredArrayModel.getConfirm_password());

    }

    @Override
    public int getItemCount() {
        return touristRegisteredArrayModels.size();
    }

    public static class TouristInfoVH extends RecyclerView.ViewHolder {
        TextView firstname,lastname,address,place_of_origin,age,gender,username,password,confirm_password;
        public TouristInfoVH(@NonNull View itemView) {
            super(itemView);
            firstname = itemView.findViewById(R.id.view_fname);
            lastname = itemView.findViewById(R.id.view_lname);
            address = itemView.findViewById(R.id.view_address);
            place_of_origin = itemView.findViewById(R.id.view_place_of_origin);
            age = itemView.findViewById(R.id.view_age);
            gender = itemView.findViewById(R.id.view_gender);
            username = itemView.findViewById(R.id.view_username);
            password = itemView.findViewById(R.id.view_password);
            confirm_password = itemView.findViewById(R.id.view_confirm_password);

        }
    }
}
