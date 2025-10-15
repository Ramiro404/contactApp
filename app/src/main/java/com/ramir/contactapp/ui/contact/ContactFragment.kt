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
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
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
    private val args: ContactFragmentArgs by navArgs()

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
        if(args.name.isNotEmpty() && args.lastname.isNotEmpty()){
            contactViewModel.add(args.name, args.lastname)
            contactAdapter.notifyDataSetChanged()
        }
        contactAdapter = ContactAdapter(onItemSelected = {
            //go to another activity
            findNavController().navigate(
                ContactFragmentDirections.actionContactFragment2ToDetailActivity(
                    name = it.name,
                    lastname = it.lastname
                )
            )
        })

        binding.rvContact.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = contactAdapter
        }
    }
}