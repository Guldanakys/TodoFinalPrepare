package com.example.guldana.mytodo

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.guldana.mytodo.models.Todo
import com.example.guldana.mytodo.models.User

@Database(entities = [Todo::class, User::class], version = 1)
abstract class ProjectDatabase : RoomDatabase() {

    abstract fun todoDao(): TodoDao

    abstract fun userDao(): UserDao
}