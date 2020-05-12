package com.example.android.appbdroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnitemClickListener {

    lateinit var contacts: List<Contact>
    lateinit var contactAdapter: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
    override fun onResume(){
        super.onResume()
        loadContacts()

        contactAdapter = ContactAdapter(contacts, this)
        rvContact.adapter = contactAdapter
        rvContact.layoutManager = LinearLayoutManager(this)
    }

    private fun loadContacts() {
        contacts = AppDatabase.getInstance(this).getDao().getAll()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.itemAdd -> {
                val intent = Intent(this, ContactActivity::class.java)
                startActivity(intent)
                return true
            }
            else -> super.onOptionsItemSelected(item)

        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
        super.onCreateOptionsMenu(menu)
    }

    override fun OnItemClicked(contact: Contact) {
        val intent = Intent(this, ContactActivity::class.java)
        val gson = Gson()
        intent.putExtra("contact",gson.toJson(contact))
        startActivity(intent)
    }
}

