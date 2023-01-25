package com.example.contactlist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.contactlist.MainActivity
import com.example.contactlist.data.modul.Contact
import com.example.contactlist.databinding.FragmentEditBinding

class EditFragment : Fragment() {

    private lateinit var binding: FragmentEditBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val contactList = (activity as MainActivity).contactList

        var contact = requireArguments().getParcelable<Contact>("contact")

        if (contact != null) {
            binding.detailImageIv.setImageResource(contact.image)
            binding.button.setOnClickListener {
                val newDetail = changeDetail(contact, contactList)
                findNavController().navigate(EditFragmentDirections.actionEditFragmentToDetailFragment(newDetail))
            }
        }
    }

    private fun changeDetail(contact: Contact, contactList: MutableList<Contact>) : Contact{
        val name = binding.editNameEdit.text.toString()
        val number = binding.editNumberEdit.text.toString()
        var findIndex: Int
        var editedContact : Contact


        if (!name.isNullOrEmpty() && number.isNullOrEmpty()) {
            findIndex = contactList.indexOf(contact)
            editedContact = Contact(name, contact.number, contact.image)
            contactList[findIndex] = editedContact
        } else if (name.isNullOrEmpty() && !number.isNullOrEmpty()){
            findIndex = contactList.indexOf(contact)
            editedContact = Contact(contact.name, number, contact.image)
            contactList[findIndex] = editedContact
        } else if (!name.isNullOrEmpty() && !number.isNullOrEmpty()) {
            findIndex = contactList.indexOf(contact)
            editedContact = Contact(name, number, contact.image)
            contactList[findIndex] = editedContact
        } else {
            findIndex = contactList.indexOf(contact)
            editedContact = Contact(contact.name, contact.number, contact.image)
            contactList[findIndex] = editedContact
        }

        return editedContact

    }
}