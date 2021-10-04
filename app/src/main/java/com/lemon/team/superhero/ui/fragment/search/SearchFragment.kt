package com.lemon.team.superhero.ui.fragment.search

import android.view.LayoutInflater
import androidx.lifecycle.lifecycleScope
import com.lemon.team.superhero.R
import com.lemon.team.superhero.databinding.FragmentSearchBinding
import com.lemon.team.superhero.model.Repository
import com.lemon.team.superhero.ui.fragment.base.BaseFragment
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class SearchFragment : BaseFragment<FragmentSearchBinding>() {
    override val layoutId: Int = R.layout.fragment_search
    override val LOG_TAG: String = "SEARCH_FRAGMENT"
    override val bindingInflater: (LayoutInflater) ->
    FragmentSearchBinding = FragmentSearchBinding::inflate

    override fun setUp() {

    }

}