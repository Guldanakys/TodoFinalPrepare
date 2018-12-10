package com.example.guldana.mytodo.login

import android.content.Context
import com.example.guldana.mytodo.App
import kotlin.concurrent.thread

class LoginPresenter(override var view: LoginContract.View?) :
    LoginContract.Presenter {

    override fun login(email: String, password: String, context: Context) {

        thread {

            val userDao = (context as App).database.userDao()

            (context as App).database.runInTransaction(object : Runnable {

                override fun run() {

                    val user = userDao.getUserByEmail(email)

                    if (user.password == password)
                        view?.onLogSuccess(user.uuid)
                    else
                        view?.onLogError()
                }
            })
        }
    }
}