package com.example.contactlist.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.contactlist.R
import com.example.contactlist.data.modul.Contact
import com.example.contactlist.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDetailBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val contact = requireArguments().getParcelable<Contact>("contact")

        if (contact != null) {
            binding.detailImageIv.setImageResource(contact.image)
            binding.detailNameTv.text = contact.name
            binding.detailNumberTv.text = contact.number

            //call button
            binding.detailCallBtn.setOnClickListener {
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.fromParts("tel", contact.number, null)
                val shareIntent = Intent.createChooser(intent, "Phone")
                startActivity(shareIntent)
            }

            //edit Button
            binding.detailEditContactIbtn.setOnClickListener {
                findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToEditFragment(contact))
            }
        } else {
            binding.detailImageIv.setImageResource(R.drawable.round_person_24)
        }




    }
}