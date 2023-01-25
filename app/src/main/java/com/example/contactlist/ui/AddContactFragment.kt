package com.example.contactlist.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.contactlist.MainActivity
import com.example.contactlist.R
import com.example.contactlist.adapter.ContactListAdapter
import com.example.contactlist.data.Datasource
import com.example.contactlist.data.modul.Contact
import com.example.contactlist.databinding.FragmentAddcontactBinding

class AddContactFragment : Fragment() {
    val TAG = "addcontact"
//    val contactList = Datasource().getContactList()
    private lateinit var binding: FragmentAddcontactBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAddcontactBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val mainActivity = (activity as MainActivity)
        val contactList = mainActivity.contactList

        val adapter = ContactListAdapter(contactList)

        binding.imageView.setImageResource(R.drawable.round_person_24)
        binding.addContactBtn.setOnClickListener {
            addContact(adapter, contactList)
            findNavController().navigate(AddContactFragmentDirections.actionAddContactFragmentToHomeFragment())
        }
    }

    private fun addContact(adapter: ContactListAdapter, contactList: MutableList<Contact>) {
        val name = binding.nameInput.text.toString()
        val number = binding.numberInput.text.toString()

        if (!name.isNullOrEmpty()){
            val newContact = Contact(name, number, R.drawable.round_person_24)
            contactList.add(newContact)
            adapter.notifyItemInserted(contactList.lastIndex)
//            Log.d(TAG, contactList.toString())
        }
    }
}