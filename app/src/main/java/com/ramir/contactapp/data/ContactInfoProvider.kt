package com.ramir.contactapp.data

import com.ramir.contactapp.domain.model.ContactInfo
import javax.inject.Inject

class ContactInfoProvider @Inject constructor() {
    fun getContactInfo(): List<ContactInfo>{
        return listOf(
            ContactInfo(1,"jUAN", "Perez"),
            ContactInfo(2, "Rocio", "Azuara")
        )
    }
}