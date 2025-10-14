package com.ramir.contactapp.ui.contact

import androidx.lifecycle.ViewModel
import com.ramir.contactapp.data.ContactInfoProvider
import com.ramir.contactapp.domain.model.ContactInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ContactViewModel @Inject constructor(
    val contactProvider: ContactInfoProvider
): ViewModel(){
    private var _contact = MutableStateFlow<List<ContactInfo>>(emptyList())
    val contact: StateFlow<List<ContactInfo>> = _contact

    init {
        _contact.value = contactProvider.getContactInfo()
    }
}