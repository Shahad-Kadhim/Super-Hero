package com.lemon.team.superhero.ui.fragment.home

import android.view.LayoutInflater
import com.lemon.team.superhero.databinding.FragmentHomeBinding
import com.lemon.team.superhero.ui.fragment.base.BaseFragment
import com.lemon.team.superhero.ui.fragment.base.BasePresenter
import com.lemon.team.superhero.util.goToFragment

class HomeFragment:BaseFragment<FragmentHomeBinding,HomePresenter>() {
    override val LOG_TAG: String="HOME_FRAGMENT"
    override val getPresenter: BasePresenter = HomePresenter()
    override val bindingInflater: (LayoutInflater) -> FragmentHomeBinding=
        FragmentHomeBinding::inflate

    override fun setUp() {

    }

    override fun callbacks() {
        binding?.searchField?.setOnEditorActionListener { view, _, _ ->
            if(view.text.isNotBlank()){
                view.goToFragment(
                    HomeFragmentDirections.actionHomeFragmentToSearchFragment(view.text.toString())
                )
                return@setOnEditorActionListener  true
            }
            return@setOnEditorActionListener false
        }
    }

}