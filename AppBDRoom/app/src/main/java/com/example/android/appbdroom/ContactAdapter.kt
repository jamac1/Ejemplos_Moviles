package com.example.android.appbdroom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.prototype_contact.view.*


class ContactAdapter(val contacts: List<Contact>, val itemClickListener: OnitemClickListener): RecyclerView.Adapter<ContactPrototype>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactPrototype {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.prototype_contact,parent,false)
        return ContactPrototype(view)
    }


    override fun getItemCount(): Int {
        return contacts.size

    }

    override fun onBindViewHolder(contactPrototype: ContactPrototype, position: Int) {
        contactPrototype.bind(contacts.get(position), itemClickListener)
    }
}
    class ContactPrototype(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvName = itemView.tvName
        val tvTelephone = itemView.tvTelephone
        val cvContact = itemView.cvContact

        fun bind(contact: Contact, itemClickListener: OnitemClickListener){
            tvName.text = contact.name
            tvTelephone.text = contact.telephone
            cvContact.setOnClickListener {
                itemClickListener.OnItemClicked(contact)
            }
        }

    }
interface OnitemClickListener{
    fun OnItemClicked(contact: Contact)
}


