package com.example.android.futbolprueba.controllers.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.futbolprueba.R
import com.example.android.futbolprueba.adapter.TeamAdapter
import com.example.android.futbolprueba.controllers.activities.DetailsActivity
import com.example.android.futbolprueba.models.ApiResponseHeader
import com.example.android.futbolprueba.models.Team
import com.example.android.futbolprueba.networking.TeamService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TeamFragment : Fragment(), TeamAdapter.OnItemClickListener {
    var team: List<Team> = ArrayList()
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_team, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.rvTeams)
        loadTeams(view.context)

    }

    private fun loadTeams(context: Context){

        Log.d("Init load", "Init")

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api-football-v1.p.rapidapi.com/v2/teams/league/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        //DECLARAMOS NUESTRO OBJETO TeamService
        val teamService: TeamService
        teamService = retrofit.create(TeamService::class.java)
        val request = teamService.getTeams("api-football-v1.p.rapidapi.com","d229813befmsh4c1646ad132a0b5p1313fcjsn9afecaefc97e")


        request.enqueue(object : Callback<ApiResponseHeader> {

            override fun onFailure(call: Call<ApiResponseHeader>, t: Throwable) {
                Log.d("Activity Fail", "Error: "+t.toString())
            }

            override fun onResponse(call: Call<ApiResponseHeader>, responseDetails: Response<ApiResponseHeader>) {

                if (responseDetails.isSuccessful) {
                    Log.d("MSG", responseDetails.message())
                    Log.d("Error Body", responseDetails.errorBody().toString())
                    Log.d("Activity Success", responseDetails.raw().toString())
                    Log.d("Activity Success", responseDetails.body().toString())
                    Log.d("Activity Success 1", responseDetails.body()?.api?.results.toString())
                    Log.d("Activity Success 2", responseDetails.body()?.api?.teams?.size.toString())


                    val teams: List<Team> = responseDetails.body()!!.api.teams ?: ArrayList()
                    recyclerView.layoutManager = LinearLayoutManager(context)
                    recyclerView.adapter = TeamAdapter(teams,context,this@TeamFragment)
                }

                else{
                    Log.d("Activity Fail", "Error: "+responseDetails.code())
                }
            }

        })

    }

    override fun onItemClicked(team: Team) {
        Log.d("Principal", "Seleccionando detalle ID: "+ team.team_id)
        val intento = Intent(context, DetailsActivity::class.java)
        intento.putExtra("Team",team)
        startActivity(intento)
    }


}