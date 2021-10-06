package com.lemon.team.superhero.ui.fragment.home

import android.view.LayoutInflater
import com.lemon.team.superhero.databinding.FragmentHomeBinding
import com.lemon.team.superhero.ui.fragment.base.BaseFragment
import com.lemon.team.superhero.ui.fragment.base.BasePresenter

class HomeFragment:BaseFragment<FragmentHomeBinding,HomePresenter>() {
    override val LOG_TAG: String="HOME_FRAGMENT"
    override val getPresenter: BasePresenter = HomePresenter()
    override val bindingInflater: (LayoutInflater) -> FragmentHomeBinding=
        FragmentHomeBinding::inflate

    override fun setUp() {

    }

    override fun callbacks() {

    }

}