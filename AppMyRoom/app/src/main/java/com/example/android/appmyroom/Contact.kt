package com.example.android.appmyroom

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//annotaciones de ROOM
@Entity
//Necesariamente tiene que ser data class
data class Contact (
    @PrimaryKey(autoGenerate = true)
    var id: Int?,

    @ColumnInfo(name="name")
    var name: String?,

    @ColumnInfo(name="telephone")
    var telephone: String?
)