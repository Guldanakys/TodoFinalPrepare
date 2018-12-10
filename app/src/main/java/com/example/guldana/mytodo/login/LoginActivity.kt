package com.example.guldana.mytodo.login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.guldana.mytodo.App
import com.example.guldana.mytodo.R
import com.example.guldana.mytodo.main.MainActivity
import com.example.guldana.mytodo.models.Todo
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import kotlin.concurrent.thread

class LoginActivity : AppCompatActivity(), LoginContract.View  {

    override val presenter: LoginContract.Presenter by inject { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        /*val todo1 = Todo(4,"Acad","You have 2", true, 1)
        val todo2 = Todo(5,"Lorem","Hours today to complete it", true, 1)
        thread {
            val todosDao = (applicationContext as App).database.todoDao()

            (applicationContext as App).database.runInTransaction(object : Runnable {

                override fun run() {
                    todosDao.insert(todo1)
                    todosDao.insert(todo2)

                    val todos = todosDao.getTodosByStatus(1, true)

                    for (t in todos) {
                        Log.d("Todo", t.done.toString())
                    }

                }
            })
        }*/

        btn_login.setOnClickListener {
            val email = edx_email.text.toString()
            val password = edx_password.text.toString()
            if(!email.isEmpty() && !password.isEmpty()) {
                presenter.login(email, password, applicationContext)
            } else {
                Toast.makeText(this, "Please fill up the credentials!", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onLogSuccess(userId: Int) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("userId", userId)
        startActivity(intent)
        finish()
        runOnUiThread {
            Toast.makeText(this, "Please check the credentials!", Toast.LENGTH_LONG).show()
        }
    }

    override fun onLogError() {
        runOnUiThread {
            Toast.makeText(this, "Please check the credentials!", Toast.LENGTH_LONG).show()
        }
    }
}
