package com.ramir.contactapp.data

import com.ramir.contactapp.domain.model.ContactInfo
import javax.inject.Inject

class ContactInfoProvider @Inject constructor() {

    private var list  = mutableListOf(
        ContactInfo(1,"jUAN", "Perez"),
        ContactInfo(2, "Rocio", "Azuara")
    )
    fun getContactInfo(): List<ContactInfo>{
        return list
    }

    fun addContact(name:String, lastname:String): Unit{
        list.add(ContactInfo(
            id = list.size,
            name = name,
            lastname  = lastname
        ))
    }
}