package com.ramir.contactapp.ui.contact.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ramir.contactapp.R
import com.ramir.contactapp.domain.model.ContactInfo

class ContactAdapter(
    private var contactInfoList: List<ContactInfo> = emptyList(),
    private val onItemSelected: (ContactInfo)-> Unit):
    RecyclerView.Adapter<ContactViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        return ContactViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
        )
    }

    override fun getItemCount() = contactInfoList.size

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.render(contactInfo = contactInfoList[position], onItemSelected)
    }

    fun updateList(list: List<ContactInfo>){
        contactInfoList = list
        notifyDataSetChanged()
    }


}