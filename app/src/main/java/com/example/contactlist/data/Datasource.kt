package com.example.contactlist.data

import com.example.contactlist.R
import com.example.contactlist.data.modul.Contact
import kotlinx.parcelize.Parcelize
class Datasource {

    fun getContactList(): MutableList<Contact>{
        return mutableListOf(
            Contact("Mr. Nutz", "491704639237", R.drawable.mrnutz),
            Contact("Super Mario", "471340934562", R.drawable.supermario),
            Contact("Sonic the Hedgehog", "447384529485", R.drawable.sonic)
        )
    }
}