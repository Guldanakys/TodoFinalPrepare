package com.example.guldana.mytodo.main

import android.content.Context
import com.example.guldana.mytodo.App
import kotlin.concurrent.thread

class DonePresenter(override var view: DoneContract.View?) :
    DoneContract.Presenter {

    override fun loadTodos(userId: Int, context: Context) {
        thread {

            val todoDao = (context as App).database.todoDao()

            (context as App).database.runInTransaction(object : Runnable {

                override fun run() {

                    val todos = todoDao.getTodosByStatus(userId, true)

                    view?.todosShow(todos)
                }
            })
        }
    }

}