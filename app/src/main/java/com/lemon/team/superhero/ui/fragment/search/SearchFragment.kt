package com.lemon.team.superhero.ui.fragment.search

import android.view.LayoutInflater
import com.lemon.team.superhero.R
import com.lemon.team.superhero.databinding.FragmentSearchBinding
import com.lemon.team.superhero.ui.fragment.base.BaseFragment


class SearchFragment : BaseFragment<FragmentSearchBinding>() {
    override val layoutId: Int = R.layout.fragment_search
    override val LOG_TAG: String = "SEARCH_FRAGMENT"
    override val bindingInflater: (LayoutInflater) ->
    FragmentSearchBinding = FragmentSearchBinding::inflate

    override fun setUp() {

    }

}