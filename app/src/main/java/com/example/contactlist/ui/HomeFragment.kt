package com.example.contactlist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import com.example.contactlist.MainActivity
import com.example.contactlist.SwipeToDelete
import com.example.contactlist.adapter.ContactListAdapter
import com.example.contactlist.data.Datasource
import com.example.contactlist.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

//    val contactList = Datasource().getContactList()
//    val TAG = "HomeFragment"
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val mainActivity = (activity as MainActivity)
        val contactList = mainActivity.contactList
        val adapter = ContactListAdapter(contactList)

        binding.contactListRv.adapter = adapter


        val swipe = ItemTouchHelper(SwipeToDelete(adapter))
        swipe.attachToRecyclerView(binding.contactListRv)

        binding.homeAddIv.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToAddContactFragment2())
        }

//        Log.d(TAG, contactList.toString())
    }
}