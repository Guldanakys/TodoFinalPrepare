package com.example.guldana.mytodo.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.guldana.mytodo.R
import com.example.guldana.mytodo.models.Todo
import kotlinx.android.synthetic.main.fragment_do.view.*

import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf


class DoFragment : Fragment(), DoContract.View {

    override val presenter: DoContract.Presenter by inject { parametersOf(this) }

    private val ADD_TASK_REQUEST = 1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_do, container, false)

        val currentUser = activity!!.intent.getIntExtra("userId", 0)

        presenter.loadTodos(currentUser, activity!!.applicationContext)

        view.flt_btn.setOnClickListener {
            val intent = Intent(activity, AddTodoActivity::class.java)
            intent.putExtra("userId", currentUser)
            startActivityForResult(intent, ADD_TASK_REQUEST)
        }
        return view
    }

    override fun todosShow(todosList: List<Todo>) {
        val adapter = TodosListAdapter(todosList)
        val recyclerView = view!!.findViewById(R.id.recycler1) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == ADD_TASK_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                Toast.makeText(activity, "To DO saved successfully!", Toast.LENGTH_LONG).show()
            }
        }
    }
}
