package com.example.guldana.mytodo.base

import com.example.guldana.mytodo.base.BasePresenter

interface BaseView<out P : BasePresenter<*>> {
    val presenter: P
}