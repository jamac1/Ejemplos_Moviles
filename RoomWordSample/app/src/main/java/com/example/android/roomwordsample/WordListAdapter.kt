package com.example.android.roomwordsample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView

class WordListAdapter internal constructor(context: Context):RecyclerView.Adapter<WordListAdapter.WorldViewHolder>(){

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var words = emptyList<Word>()

    inner class WorldViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val wordItemView: TextView = itemView.findViewById(R.id.textView)

    }
    override fun onCreateViewHolder(parent: ViewGroup, ViewType: Int): WorldViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent,false)
        return WorldViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: WordListAdapter.WorldViewHolder, position: Int) {
        val current = words[position]
        holder.wordItemView.text = current.word
    }
    internal fun setWords(words: List<Word>){
        this.words = words
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return words.size
    }
}