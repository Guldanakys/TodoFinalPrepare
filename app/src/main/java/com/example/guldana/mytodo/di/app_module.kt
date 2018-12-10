package com.example.guldana.mytodo.di

import com.example.guldana.mytodo.login.LoginContract
import com.example.guldana.mytodo.login.LoginPresenter
import com.example.guldana.mytodo.main.DoContract
import com.example.guldana.mytodo.main.DoPresenter
import com.example.guldana.mytodo.main.DoneContract
import com.example.guldana.mytodo.main.DonePresenter
import org.koin.dsl.module.module

val appModule = module {

    factory { (view: LoginContract.View) -> LoginPresenter(view) as LoginContract.Presenter }
    factory { (view: DoContract.View) -> DoPresenter(view) as DoContract.Presenter }
    factory { (view: DoneContract.View) -> DonePresenter(view) as DoneContract.Presenter }
}

val myTodo = listOf(appModule)