package com.example.android.appmyroom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.protype_contact.view.*

//le aumento un parametro q pasa el click
class ContactAdapter(val contacts: List<Contact>, val itemClickListener: onItemClickListener ):
    RecyclerView.Adapter<ContactPrototype>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactPrototype {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.protype_contact,parent,false)
        return ContactPrototype(view)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(contactPrototype: ContactPrototype, position: Int) {
        contactPrototype.bind(contacts[position],itemClickListener)
    }

}

class ContactPrototype(itemView: View): RecyclerView.ViewHolder(itemView) {
    val tvName = itemView.tvName
    val tvTelephone = itemView.tvTelephone
    val cvContact = itemView.cvContact

    //paso el elemento que hice click en el cardview
    fun bind(contact: Contact, itemClickListener: onItemClickListener) {
        //
        tvName.text = contact.name
        tvTelephone.text = contact.telephone
        //capturo el registro q se dio clic
        cvContact.setOnClickListener {
            itemClickListener.OnItemClicked(contact)
        }


    }
}

    //creo la interfaz
    interface onItemClickListener {
        fun OnItemClicked(contact: Contact)
    }


