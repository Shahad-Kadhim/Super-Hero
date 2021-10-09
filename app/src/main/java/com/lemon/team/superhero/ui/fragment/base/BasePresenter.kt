package com.lemon.team.superhero.ui.fragment.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

abstract class BasePresenter {

    val customScope= CoroutineScope(Dispatchers.Main)

}