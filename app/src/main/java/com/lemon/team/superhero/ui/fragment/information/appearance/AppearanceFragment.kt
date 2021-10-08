package com.lemon.team.superhero.ui.fragment.information.appearance

import android.view.LayoutInflater
import com.lemon.team.superhero.databinding.FragmentAppearanceBinding
import com.lemon.team.superhero.ui.fragment.base.BaseFragment
import com.lemon.team.superhero.ui.fragment.base.BasePresenter

class AppearanceFragment : BaseFragment<FragmentAppearanceBinding, AppearancePresenter>() {
    override val LOG_TAG: String = "Appearance_FRAGMENT"
    override val bindingInflater: (LayoutInflater) -> FragmentAppearanceBinding =
        FragmentAppearanceBinding::inflate
    override val getPresenter: BasePresenter = AppearancePresenter()

    override fun setUp() {

    }

    override fun callbacks() {

    }

}