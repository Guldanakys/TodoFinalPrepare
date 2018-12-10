package com.example.guldana.mytodo.main

import android.content.Context
import com.example.guldana.mytodo.base.BasePresenter
import com.example.guldana.mytodo.base.BaseView
import com.example.guldana.mytodo.models.Todo

interface DoneContract {
    interface View : BaseView<Presenter> {
        fun todosShow(todosList: List<Todo>)
    }

    interface Presenter : BasePresenter<View> {
        fun loadTodos(userId: Int, context: Context)
    }
}