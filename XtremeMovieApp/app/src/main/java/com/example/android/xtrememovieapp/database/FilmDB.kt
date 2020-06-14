package com.example.android.xtrememovieapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.android.xtrememovieapp.models.Film

@Database(entities = [Film::class], version = 1)
abstract class FilmDB: RoomDatabase() {
    abstract fun getFilmDAO(): FilmDAO

    companion object{
        private var INSTANCE : FilmDB?= null

        fun getInstance(context: Context): FilmDB {
            if(INSTANCE == null){
                INSTANCE = Room.databaseBuilder(context, FilmDB::class.java,"film.db").allowMainThreadQueries().build()

            }
            return INSTANCE as FilmDB
        }
    }
}