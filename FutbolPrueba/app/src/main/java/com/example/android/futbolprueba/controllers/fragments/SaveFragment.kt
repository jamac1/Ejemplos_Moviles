package com.example.android.futbolprueba.controllers.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.futbolprueba.R
import com.example.android.futbolprueba.adapter.TeamAdapter
import com.example.android.futbolprueba.database.TeamDB
import com.example.android.futbolprueba.models.Team

class SaveFragment : Fragment(), TeamAdapter.OnItemClickListener {

    var team: List<Team> = ArrayList()
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_save, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        team = TeamDB.getInstance(view.context).getTeamDAO().getAllTeams()
        recyclerView = view.findViewById(R.id.TeamSave)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = TeamAdapter(team,view.context,this)

    }

    override fun onItemClicked(team: Team) {
        Log.d("Onclick Favoritos","No hacer nada");
    }
}
