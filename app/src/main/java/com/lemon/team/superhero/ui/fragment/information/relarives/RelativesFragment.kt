package com.lemon.team.superhero.ui.fragment.information.relarives

import android.util.Log
import android.view.LayoutInflater
import androidx.navigation.fragment.navArgs
import com.lemon.team.superhero.databinding.FragmentRelativesBinding
import com.lemon.team.superhero.ui.fragment.base.BaseFragment
import com.lemon.team.superhero.ui.fragment.base.BasePresenter

class RelativesFragment : BaseFragment<FragmentRelativesBinding, RelativesPresenter>() {
    val args :RelativesFragmentArgs by navArgs()
    override val LOG_TAG: String = "Relatives_FRAGMENT"
    override val bindingInflater: (LayoutInflater) -> FragmentRelativesBinding =
        FragmentRelativesBinding::inflate
    override val getPresenter: BasePresenter = RelativesPresenter()

    override fun setUp() {
        Log.i(LOG_TAG,args.superHeroId)
    }

    override fun callbacks() {

    }

}