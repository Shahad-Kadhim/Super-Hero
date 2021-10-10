package com.lemon.team.superhero.ui.fragment.details

import com.lemon.team.superhero.ui.fragment.base.BaseInteractionListener

interface InfoInteractionListener:BaseInteractionListener {
    fun onClickNext(position:Int)
    fun onClickPrevious(position: Int)
}
