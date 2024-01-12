package com.route.basicsc39

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

class ContactsAdapterV2(var contacts: ArrayList<ContactDM>): Adapter<ContactsAdapterV2.ViewHolder>() {
    var onItemClick:OnItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contact,
            parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = contacts.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = contacts[position]
        holder.nameTv.text = contact.name
        holder.phoneTv.text = contact.phoneNumber
        holder.profileImage.setImageResource(contact.imageId)

        holder.profileImage.setOnClickListener {view->
            onItemClick?.onClick(contact, position)
        }
    }

     fun interface OnItemClick{
        fun onClick(contact: ContactDM, index: Int)
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val nameTv: TextView = itemView.findViewById(R.id.contactName)
        val phoneTv: TextView = itemView.findViewById(R.id.contactPhone)
        val profileImage: ImageView = itemView.findViewById(R.id.contactImage)

    }
}