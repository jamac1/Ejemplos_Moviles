package com.example.android.appmycontact

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper


import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.prototype_contact.*

class MainActivity : AppCompatActivity(), ContactPrototype.OnItemClickListener {


    val REQUEST_CODE = 1
    var contacts = ArrayList<Contact>()
    var contactAdapter = ContactAdapter(contacts)
    override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadContacts()
        initView()

    }

   fun initView() {

        rvContact.adapter = contactAdapter
        rvContact.layoutManager= LinearLayoutManager(this)
        val itemTouchHelper = ItemTouchHelper(SwipeToDelete(contactAdapter))
       itemTouchHelper.attachToRecyclerView(rvContact)
    }

    private fun loadContacts() {
        contacts.add(Contact("Yazmin","98754623"))
        contacts.add(Contact("Joseph","99932654"))
        contacts.add(Contact("Marisol","8756421"))
    }
    //ctrl+ o

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       val id= item.itemId
        if(id==R.id.itemAdd) {
            val intent = Intent(this, ContactActivity::class.java)
//        // envio normal startActivity(intent)
            startActivityForResult(intent, REQUEST_CODE)
        }else{
            Toast.makeText(this,"DESLIZE HACIA LA IZQUIERDA O DERECHA EL ELEMENTO A ELIMINAR",Toast.LENGTH_LONG).show()
        }
       return super.onOptionsItemSelected(item)
   }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==REQUEST_CODE){
            if(resultCode==Activity.RESULT_OK) {
                val name = data!!.getStringExtra("keyName")
                val telephone = data!!.getStringExtra("keyTelephone")
                val contact = Contact(name, telephone)
                contacts.add(contact)
            }
        }
    }

    override fun onItemclick(contact: Contact) {
        TODO("Not yet implemented")
    }


}
