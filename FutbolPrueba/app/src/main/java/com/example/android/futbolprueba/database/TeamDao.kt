package com.example.android.futbolprueba.database

import androidx.room.*
import com.example.android.futbolprueba.models.Team

@Dao
interface TeamDao {
    @Insert
    fun insertTeam(vararg team: Team)

    @Query("SELECT * FROM teams ")
     fun getAllTeams(): List<Team>

    @Delete
    fun deleteTeams(vararg team: Team)

    @Update
    fun updateTeams(vararg team: Team)

}