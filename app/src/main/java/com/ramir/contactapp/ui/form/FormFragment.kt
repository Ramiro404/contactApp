package com.ramir.contactapp.ui.form

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.navigateUp
import androidx.transition.Visibility
import com.ramir.contactapp.R
import com.ramir.contactapp.databinding.FragmentFormBinding
import com.ramir.contactapp.domain.model.ContactInfo
import com.ramir.contactapp.ui.contact.ContactFragment
import com.ramir.contactapp.ui.contact.adapter.ContactAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FormFragment : Fragment() {
    private val formViewModel by viewModels<FormViewModel>()
    private var _binding: FragmentFormBinding? = null
    private val binding get() = _binding!!
    private  lateinit var contactAdapter: ContactAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_form, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    private fun initListener() {
        binding.btnSave.setOnClickListener {
            val name =  binding.etName.text.toString()
            val lastname = binding.etLastname.text.toString()
            if(name.isNotEmpty() && lastname.isNotEmpty()){
                findNavController().navigate(
                    FormFragmentDirections.actionFormFragment2ToContactFragment2(
                        name = name,
                        lastname  = lastname)
                )
            }else{
                if(name.isEmpty()){
                    binding.tvErrorName.visibility = View.VISIBLE
                }
                if(lastname.isEmpty()){
                    binding.tvErrorLastname.visibility = View.VISIBLE
                }
            }
        }
    }
}