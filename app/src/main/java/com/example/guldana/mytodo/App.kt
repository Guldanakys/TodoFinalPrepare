package com.example.guldana.mytodo

import android.app.Application
import android.arch.persistence.room.Room
import com.example.guldana.mytodo.di.myTodo
import org.koin.android.ext.android.startKoin

class App : Application() {

    lateinit var database: ProjectDatabase

    override fun onCreate() {
        super.onCreate()

        instance = this
        startKoin(this, myTodo)

        database = Room.databaseBuilder(applicationContext,
            ProjectDatabase::class.java,
            "MyTodoDb")
            .allowMainThreadQueries()
            .build()
    }

    companion object {
        @JvmStatic var instance: App? = null
            private set
    }
}