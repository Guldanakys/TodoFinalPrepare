package com.example.guldana.mytodo.login

import android.content.Context
import com.example.guldana.mytodo.base.BasePresenter
import com.example.guldana.mytodo.base.BaseView

interface LoginContract {
    interface View : BaseView<Presenter> {
        fun onLogSuccess(userId: Int)
        fun onLogError()
    }

    interface Presenter : BasePresenter<View> {
        fun login(email: String, password: String, context: Context)
    }
}