package com.example.guldana.mytodo.models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "users")
data class User(

    @PrimaryKey(autoGenerate = true)
    val uuid : Int,

    @ColumnInfo(name = "email")
    val email : String,

    @ColumnInfo(name = "password")
    val password : String
)