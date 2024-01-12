package com.route.basicsc39;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {
    ArrayList<ContactDM> contacts;
    OnItemClick onImageClick;

    OnItemClick onItemClick;

    public ContactsAdapter(ArrayList<ContactDM> contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.e("ContactsAdapter", "onCreateViewHolder");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.e("ContactsAdapter", "onBindViewHolder: " + position);
        ContactDM contactDM = contacts.get(position);
        holder.nameTv.setText(contactDM.getName());
        holder.phoneTv.setText(contactDM.getPhoneNumber());
        holder.profileImage.setImageResource(contactDM.getImageId());
        if(onImageClick != null){
            holder.profileImage.setOnClickListener(view -> onImageClick.onClick(contactDM, position));
        }
        if(onItemClick != null){
            holder.itemView.setOnClickListener(view -> {
                onItemClick.onClick(contactDM, position);
            });
        }


    }


    @Override
    public int getItemCount() {
        return contacts.size();
    }


    interface OnItemClick {
        void onClick(ContactDM contactDM, int index);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTv;
        TextView phoneTv;
        ImageView profileImage;

        ViewHolder(View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.contactName);
            phoneTv = itemView.findViewById(R.id.contactPhone);
            profileImage = itemView.findViewById(R.id.contactImage);
        }

    }
}