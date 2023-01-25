package com.example.contactlist.data.modul

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Contact(val name: String, val number: String, val image: Int) : Parcelable