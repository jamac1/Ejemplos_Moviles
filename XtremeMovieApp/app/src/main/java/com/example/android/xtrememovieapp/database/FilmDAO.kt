package com.example.android.xtrememovieapp.database

import androidx.room.*
import com.example.android.xtrememovieapp.models.Film

@Dao
interface FilmDAO {
    @Insert
    fun insertFilm(vararg film: Film)

    @Query("SELECT * FROM films")
    fun getAllFilm(): List<Film>

    @Delete
    fun deleteFilm(vararg team: Film)

    @Update
    fun updateFilm(vararg team: Film)
}