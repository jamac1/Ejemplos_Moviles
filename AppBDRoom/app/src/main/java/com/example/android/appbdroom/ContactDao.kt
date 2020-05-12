package com.example.android.appbdroom

import androidx.room.*

@Dao
interface ContactDao {
    //Room solo trabaja solo con List y cursores
    @Query("select * from Contact")
    fun getAll(): List<Contact>

    @Insert
    fun insertContact(vararg contact:Contact)

    @Delete
    fun deleteContact(vararg contact:Contact)

    @Update
    fun updateContact(vararg contact:Contact)
}