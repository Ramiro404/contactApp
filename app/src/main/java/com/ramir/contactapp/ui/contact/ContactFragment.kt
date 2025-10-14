package com.ramir.contactapp.ui.contact

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ramir.contactapp.R
import com.ramir.contactapp.databinding.FragmentContactBinding
import com.ramir.contactapp.ui.contact.adapter.ContactAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class ContactFragment : Fragment() {
    private val contactViewModel by viewModels<ContactViewModel>()
    private var _binding: FragmentContactBinding? = null
    private val binding get() = _binding!!
    private lateinit var contactAdapter: ContactAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initList()
        initUI()
    }

    private fun initList() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                contactViewModel.contact.collect{
                    contactAdapter.updateList(it)
                }
            }
        }
    }

    private fun initUI(){
        contactAdapter = ContactAdapter(onItemSelected = {
            //go to another activity
        })

        binding.rvContact.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = contactAdapter
        }
    }
}