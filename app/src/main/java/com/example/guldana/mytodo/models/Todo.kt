package com.example.guldana.mytodo.models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "todos", foreignKeys = [ForeignKey(entity = User::class,
        parentColumns = arrayOf("uuid"),
        childColumns = arrayOf("user_id"),
        onDelete = ForeignKey.CASCADE)]
)
data class Todo(

    @PrimaryKey(autoGenerate = true)
    val id : Int,

    val title : String,

    val body : String,

    val done : Boolean = false,

    @ColumnInfo(name = "user_id")
    val user_id : Int
)