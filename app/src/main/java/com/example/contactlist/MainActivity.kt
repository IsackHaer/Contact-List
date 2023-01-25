package com.example.contactlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.contactlist.data.Datasource


class MainActivity : AppCompatActivity() {

    val datasource = Datasource()
    val contactList = datasource.getContactList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }


}