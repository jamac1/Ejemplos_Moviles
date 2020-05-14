package com.example.android.futbolprueba.controller.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.futbolprueba.R
import com.example.android.futbolprueba.adapter.TeamAdapter
import com.example.android.futbolprueba.models.ApiResponseDetails
import com.example.android.futbolprueba.models.ApiResponseHeader
import com.example.android.futbolprueba.models.Team
import com.example.android.futbolprueba.networking.TeamService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var teamRecyclerview: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        teamRecyclerview = findViewById(R.id.rvTeams)
        loadTeams(this)
    }
    private fun loadTeams(context: Context){
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api-football-v1.p.rapidapi.com/v2/teams/league/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        val teamService: TeamService
        teamService = retrofit.create(TeamService::class.java)
        val request = teamService.getTeams("api-football-v1.p.rapidapi.com","")
        request.enqueue(object : Callback<ApiResponseHeader>{
            override fun onFailure(call: Call<ApiResponseHeader>, t: Throwable) {
                Log.d("Activity Fail","Error: "+t.toString())
            }

            override fun onResponse(
                call: Call<ApiResponseHeader>,
                responseDetails: Response<ApiResponseHeader>
            ) {
                if(responseDetails.isSuccessful){
                    val teams: List<Team> = responseDetails.body()!!.api.teams ?: ArrayList()
                    teamRecyclerview.layoutManager = LinearLayoutManager(context)
                    teamRecyclerview.adapter = TeamAdapter(teams, context)


                }
                else{
                    Log.d("Activity Fail", "Error: "+responseDetails.code())
                }
            }
        })
    }
}
