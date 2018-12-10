package com.example.guldana.mytodo.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.guldana.mytodo.R
import com.example.guldana.mytodo.models.Todo
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf


class DoneFragment : Fragment(), DoneContract.View {

    override val presenter: DoneContract.Presenter by inject { parametersOf(this) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_done, container, false)

        val currentUser = activity!!.intent.getIntExtra("userId", 0)

        presenter.loadTodos(currentUser, activity!!.applicationContext)
        return view
    }

    override fun todosShow(todosList: List<Todo>) {
        val adapter = TodosListAdapter(todosList)
        val recyclerView = view!!.findViewById(R.id.recycler2) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
    }
}
