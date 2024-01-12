package com.route.basicsc39

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class WhatsAppContactsList : AppCompatActivity() {
    lateinit var contactsRecyclerView: RecyclerView
    lateinit var adapter: ContactsAdapterV2
    lateinit var contacts: ArrayList<ContactDM>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_whats_app_contacts_list)
        initContactsList()
        initRecyclerView()


    }
    fun initRecyclerView(){
        contactsRecyclerView = findViewById(R.id.contactsRecyclerView)
        adapter = ContactsAdapterV2(contacts)
        adapter.onItemClick = ContactsAdapterV2.OnItemClick { contact, index ->

        }
        contactsRecyclerView.adapter = adapter

    }
    fun initContactsList(){
        for(i: Int in 100 downTo  0 step 2){
            contacts.add(ContactDM(R.drawable.ic_person, "name $i", "01111111$i"))
        }
    }
}