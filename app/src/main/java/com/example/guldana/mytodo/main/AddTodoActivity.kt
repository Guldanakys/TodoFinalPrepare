package com.example.guldana.mytodo.main

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.guldana.mytodo.App
import com.example.guldana.mytodo.R
import com.example.guldana.mytodo.models.Todo
import kotlinx.android.synthetic.main.activity_add_todo.*
import kotlin.concurrent.thread

class AddTodoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_todo)

        val currentUser = this.intent.getIntExtra("userId", 0)

        btn_save.setOnClickListener {
            val title = edx_title.text.toString()
            val body = edx_body.text.toString()
            if(!title.isEmpty() && !body.isEmpty()) {
                thread {
                    val todosDao = (applicationContext as App).database.todoDao()

                    val d_id = todosDao.getTodosCount() + 1
                    val todo = Todo(id = d_id,title = title, body = body, user_id = currentUser)
                    todosDao.insert(todo)
                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("userId", currentUser)
                    //startActivityForResult(intent, ADD_TASK_REQUEST)
                    startActivity(intent)
                    //setResult(Activity.RESULT_OK, result)
                    finish()
                }
            } else {
                Toast.makeText(this, "Please fill title and body!", Toast.LENGTH_LONG).show()
            }
        }


    }
}
