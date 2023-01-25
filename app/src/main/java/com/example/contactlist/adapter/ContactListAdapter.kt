package com.example.contactlist.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.contactlist.R
import com.example.contactlist.data.modul.Contact
import com.example.contactlist.ui.HomeFragmentDirections

class ContactListAdapter(
    private val dataset: MutableList<Contact>
) : RecyclerView.Adapter<ContactListAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View): ViewHolder(view) {
        val contactName = view.findViewById<TextView>(R.id.name_tv)
        val cardview = view.findViewById<CardView>(R.id.cardview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.contactlist_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val contact = dataset[position]

        holder.contactName.text = contact.name

        holder.cardview.setOnClickListener {
            holder.itemView.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(contact))
        }
    }

    fun deleteContact(position: Int) {
        dataset.removeAt(position)
        notifyItemRemoved(position)
    }
}