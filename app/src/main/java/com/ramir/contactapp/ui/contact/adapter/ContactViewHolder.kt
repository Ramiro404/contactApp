package com.ramir.contactapp.ui.contact.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ramir.contactapp.databinding.ItemContactBinding
import com.ramir.contactapp.domain.model.ContactInfo

class ContactViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemContactBinding.bind(view)

    fun render(contactInfo: ContactInfo, onItemSelected:(ContactInfo) -> Unit){
        binding.tvTitle.text = contactInfo.name + " " + contactInfo.lastname
        binding.parent.setOnClickListener {
            onItemSelected(contactInfo)
        }
    }

}