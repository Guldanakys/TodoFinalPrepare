package com.example.guldana.mytodo.main

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.guldana.mytodo.R
import com.example.guldana.mytodo.models.Todo
import kotlinx.android.synthetic.main.todo_list_item.view.*

class TodosListAdapter(private val todos: List<Todo>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    @SuppressLint("WrongConstant")
    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        p0.itemView.title.text = todos[p1].title
        p0.itemView.body.text = todos[p1].body
        p0.itemView.todo_id.text = todos[p1].id.toString()
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        return TodosViewHolder(
            LayoutInflater.from(p0.context)
            .inflate(R.layout.todo_list_item, p0, false))
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    class TodosViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView)
}