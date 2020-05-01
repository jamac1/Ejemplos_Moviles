package com.example.android.kotlinrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class recyclerViewAdapter(val userList:ArrayList<userDataModel>,var itemClickListener: OnItemClickListener):
    RecyclerView.Adapter<recyclerViewAdapter.ViewHolder>() {

       override fun onCreateViewHolder( parent: ViewGroup, viewType: Int):ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent,false)
           return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: recyclerViewAdapter.ViewHolder, position: Int) {
        var user:userDataModel = userList[position]
        holder.title.text= user.title
        holder.desc.text= user.desc
        holder.bind(user, itemClickListener)

    }

    class ViewHolder (item: View):RecyclerView.ViewHolder(item){
        var title:TextView = item.findViewById(R.id.tvTitle)
        var desc:TextView = item.findViewById(R.id.tvDescription)

        fun bind(user:userDataModel, clickListener: OnItemClickListener){
            title.text = user.title
            desc.text = user.desc
            itemView.setOnClickListener{clickListener.onItemClick(user)}
        }

    }
    interface OnItemClickListener{
        fun onItemClick(user:userDataModel)

    }

}