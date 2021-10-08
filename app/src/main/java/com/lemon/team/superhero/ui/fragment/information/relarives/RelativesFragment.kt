package com.lemon.team.superhero.ui.fragment.information.relarives

import android.view.LayoutInflater
import com.lemon.team.superhero.databinding.FragmentRelativesBinding
import com.lemon.team.superhero.ui.fragment.base.BaseFragment
import com.lemon.team.superhero.ui.fragment.base.BasePresenter

class RelativesFragment : BaseFragment<FragmentRelativesBinding, RelativesPresenter>() {
    override val LOG_TAG: String = "Relatives_FRAGMENT"
    override val bindingInflater: (LayoutInflater) -> FragmentRelativesBinding =
        FragmentRelativesBinding::inflate
    override val getPresenter: BasePresenter = RelativesPresenter()

    override fun setUp() {

    }

    override fun callbacks() {

    }

}