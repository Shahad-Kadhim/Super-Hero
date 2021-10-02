package com.lemon.team.superhero.ui.fragment.details

import android.view.LayoutInflater
import com.lemon.team.superhero.R
import com.lemon.team.superhero.databinding.FragmentDetailsBinding
import com.lemon.team.superhero.ui.fragment.base.BaseFragment

class DetailsFragment : BaseFragment<FragmentDetailsBinding>() {
    override val layoutId: Int = R.layout.fragment_details
    override val LOG_TAG: String = "DETAILS_FRAGMENT"
    override val bindingInflater: (LayoutInflater) -> FragmentDetailsBinding =
    FragmentDetailsBinding::inflate

    override fun setUp() {

    }

}