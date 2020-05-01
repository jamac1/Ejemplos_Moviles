package com.example.android.appmycontact

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.prototype_contact.view.*

class ContactAdapter(var contacts: ArrayList<Contact>,var itemClickListener: OnItemClickListener): RecyclerView.Adapter<ContactPrototype>() {

    //1crea el prototipo para el viewholder para cada fila
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactPrototype {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.prototype_contact,parent,false)
        return ContactPrototype(view)
    }

    //2Devuelve la cantidad de elementos
    override fun getItemCount(): Int {
       return contacts.size
    }

    //3conecta la informacion de la vista para cada fila
    override fun onBindViewHolder(contactPrototype: ContactPrototype, position: Int) {
        //contactPrototype.bind(contacts.get(position))
        var contact:Contact = contacts(position)
        contactPrototype.bind(contacts.get(position),itemClickListener)

    }
    fun deleteItem(position: Int) {
        contacts.removeAt(position)
        notifyItemRemoved(position)
    }

}

class ContactPrototype(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvName = itemView.tvName
    val tvTelephone= itemView.tvTelephone
    fun bind(contact: Contact, clickListener: OnItemClickListener){
        tvName.text = contact.name
        tvTelephone.text = contact.telephone
        itemView.setOnClickListener{
            clickListener.onItemclick()
        }
    }
interface OnItemClickListener{
    fun onItemclick(contact: Contact)
}

}
