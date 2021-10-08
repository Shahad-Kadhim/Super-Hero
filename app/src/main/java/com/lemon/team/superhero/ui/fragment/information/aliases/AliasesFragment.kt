package com.lemon.team.superhero.ui.fragment.information.aliases

import android.view.LayoutInflater
import com.lemon.team.superhero.databinding.FragmentAliasesBinding
import com.lemon.team.superhero.ui.fragment.base.BaseFragment
import com.lemon.team.superhero.ui.fragment.base.BasePresenter

class AliasesFragment : BaseFragment<FragmentAliasesBinding, AliasesPresenter>() {
    override val LOG_TAG: String = "Aliases_FRAGMENT"
    override val bindingInflater: (LayoutInflater) -> FragmentAliasesBinding =
        FragmentAliasesBinding::inflate
    override val getPresenter: BasePresenter = AliasesPresenter()

    override fun setUp() {

    }

    override fun callbacks() {

    }

}